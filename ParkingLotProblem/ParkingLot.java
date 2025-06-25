package ParkingLotProblem;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import ParkingLotProblem.Components.SpotType;
import ParkingLotProblem.Components.Ticket;
import ParkingLotProblem.Components.VehicleType;
import ParkingLotProblem.Components.MoneyCalculation.FeeCalculator;
import ParkingLotProblem.Components.MoneyCalculation.Rate;
import ParkingLotProblem.Components.ParkingAreaCompoenent.FourWheelerParkingSpot;
import ParkingLotProblem.Components.ParkingAreaCompoenent.ParkingSpot;
import ParkingLotProblem.Components.ParkingAreaCompoenent.TwoWheelerParkingSpot;
import ParkingLotProblem.Components.ParkingExceptions.InvalidTicketException;
import ParkingLotProblem.Components.ParkingExceptions.NoAvailableSpotException;
import ParkingLotProblem.Components.VehicleCompoenent.Vehicle;

public class ParkingLot {
    private static volatile ParkingLot instance = null;

    //available spot queue by SpotType
    private final Map<SpotType, ConcurrentLinkedQueue<ParkingSpot>> availableSpots = new ConcurrentHashMap<>();

    //Ticket map using TicketId -> Ticket
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    //all parking spot (spotId -> parkingSpot)
    private final Map<String, ParkingSpot> allSpots = new ConcurrentHashMap<>();

    //Rate for different VehicleType (vehicleType -> Rate)
    private final Map<VehicleType, Rate> rateMap = new ConcurrentHashMap<>();

    private final  FeeCalculator feeCalculator;

    private ParkingLot(int numTwoWheelerSpots, int numFourWheelerSpots, Rate twoWheelRate, Rate fourWheelerRate, FeeCalculator feeCalculator) {
        this.feeCalculator = feeCalculator;

        availableSpots.put(SpotType.TWO_WHEELER_SPOT, new ConcurrentLinkedQueue<>());
        availableSpots.put(SpotType.FOUR_WHEELER_SPOT, new ConcurrentLinkedQueue<>());

        //Initilising two wheeler spot
        for(int i = 0; i < numTwoWheelerSpots; i++) {
            String spotId = "T" + i;
            ParkingSpot spot = new TwoWheelerParkingSpot(spotId);
            allSpots.put(spotId, spot);
            availableSpots.get(SpotType.TWO_WHEELER_SPOT).offer(spot);
        }

        //Initilisiing four wheeler spot
        for(int i = 0; i < numFourWheelerSpots; i++) {
            String spotId = "F" + i;
            ParkingSpot spot = new FourWheelerParkingSpot(spotId);
            allSpots.put(spotId, spot);
            availableSpots.get(SpotType.FOUR_WHEELER_SPOT).offer(spot);
        }

        //initilising rateMap
        rateMap.put(VehicleType.TWO_WHEELER, twoWheelRate);
        rateMap.put(VehicleType.FOUR_WHEELER, fourWheelerRate);
    }

    /*
     * Initialize the singleton instance. Should be called once at application startup.
     * If called multiple times, subsequent calls are ignored.
    */
    public static ParkingLot getInstance(int numTwoWheelerSpots, int numFourWheelerSpots, Rate twoWheelRate, Rate fourWheelRate, FeeCalculator feeCalculator) {
        if(instance == null) {
            synchronized(ParkingLot.class) {
                if(instance == null) {
                    instance = new ParkingLot(numTwoWheelerSpots, numFourWheelerSpots, twoWheelRate, fourWheelRate, feeCalculator);
                }
            }
        }

        return instance;
    }

    /** If already initialized, this returns the instance. */
    public static ParkingLot getInstance() {
        if(instance == null) {
            throw new IllegalStateException("ParkingLot is not initialised. call getInstance(...)");
        }

        return instance;
    }

    /**
     * Park a vehicle: assign a spot and return a Ticket.
     * @throws NoAvailableSpotException if no spot available for the vehicle type
    */
    public Ticket parkVehicle(Vehicle vehicle) throws NoAvailableSpotException {
        VehicleType vType = vehicle.getVehicleType();
        SpotType sType = SpotType.getSpotType(vType);

        ConcurrentLinkedQueue<ParkingSpot> queue = availableSpots.get(sType);
        ParkingSpot spot = queue.poll();

        if(spot == null) {
            throw new NoAvailableSpotException("No available spot for vehicle type: " + vType);
        }

        //Mark as occupied
        spot.occupy();

        //Create Ticket
        Ticket ticket = new Ticket(vehicle.getVehicleNumber(), vType, spot.getId());
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    /**
     * Unpark a vehicle given ticketId: compute fee, free spot, and return fee.
     * @throws InvalidTicketException if ticketId not found or already exited
    */
    public double unparkVehicle(String ticketId) throws InvalidTicketException {
        Ticket ticket = activeTickets.get(ticketId);

        if(ticket == null) {
            throw new InvalidTicketException("Invalid or unknown ticket with ticketId : " + ticketId);
        }

        if(ticket.getExitTime() != null) {
            throw new InvalidTicketException("Ticket already used for exit with ticketId : " + ticketId);
        }

        //record exitTime
        ticket.setExitTime(LocalDateTime.now());

        //Fee calculation
        Rate rate = rateMap.get(ticket.getVehicleType());
        double fee = feeCalculator.calculateFee(ticket.getEntryTime(), ticket.getExitTime(), rate);

        //Fee SPot
        String spotId = ticket.getSpotId();
        ParkingSpot spot = allSpots.get(spotId);

        if(spot == null) {
            // This should not happen if data consistent
            throw new IllegalStateException("Spot not found as for :" + spotId);
        }
        spot.vacate();

        //Add back the avialable spot in availableSpot
        availableSpots.get(spot.getSpotType()).offer(spot);

        //Rmove the ticket from active ticket
        activeTickets.remove(ticketId);

        return fee;
    }


    /** 
     * Check number of available spots for a vehicle type 
     */
    public int getAvailableSpotCount(VehicleType vehicleType) {
        SpotType spotType = SpotType.getSpotType(vehicleType);

        ConcurrentLinkedQueue<ParkingSpot> queue = availableSpots.get(spotType);

        return queue.size();
    }
}