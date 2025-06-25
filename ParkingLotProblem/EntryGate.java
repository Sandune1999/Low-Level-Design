package ParkingLotProblem;

import ParkingLotProblem.Components.Ticket;
import ParkingLotProblem.Components.ParkingExceptions.NoAvailableSpotException;
import ParkingLotProblem.Components.VehicleCompoenent.Vehicle;

public class EntryGate {
    private final ParkingLot parkingLot;

    public EntryGate() {
        this.parkingLot = ParkingLot.getInstance();
    }

    /**
     * Attempt to park the vehicle. Returns a Ticket if successful.
     */
    public Ticket parkVehicle(Vehicle vehicle) {
        try {
            Ticket ticket = parkingLot.parkVehicle(vehicle);

            System.out.println("VehicleNumber [" + vehicle.getVehicleNumber() + "] parked at spot " + ticket.getSpotId() + ", ticketId = " + ticket.getTicketId());

            return ticket;
        } catch(NoAvailableSpotException e) {
            System.err.println("Parking failed for vehicle [" + vehicle.getVehicleNumber() + "]. " + e.getMessage());
            return null;
        }
    }
}
