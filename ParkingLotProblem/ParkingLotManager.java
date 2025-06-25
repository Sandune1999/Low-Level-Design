package ParkingLotProblem;

import ParkingLotProblem.Components.Ticket;
import ParkingLotProblem.Components.VehicleType;
import ParkingLotProblem.Components.MoneyCalculation.DefaultFeeCalculator;
import ParkingLotProblem.Components.MoneyCalculation.Rate;
import ParkingLotProblem.Components.VehicleCompoenent.FourWheelerVehicle;
import ParkingLotProblem.Components.VehicleCompoenent.TwoWheelerVehicle;
import ParkingLotProblem.Components.VehicleCompoenent.Vehicle;

public class ParkingLotManager {
    public static void main(String args[]) {

        //parkingLot instance creatation
        int numTwoWheelerSpots = 5;
        int numFourWheelerSpots = 3;
        Rate twoWheelerRate = new Rate(20.0, 1.0);
        Rate fourWheelRate = new Rate(50.0, 2.0);

        ParkingLot.getInstance(numTwoWheelerSpots, numFourWheelerSpots, twoWheelerRate, fourWheelRate, new DefaultFeeCalculator());

        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();

        //Simulate some parking vehicle
        Vehicle bike1 = new TwoWheelerVehicle("BIKE-123");
        Ticket t1 = entryGate.parkVehicle(bike1);

        // try {
        //     Thread.sleep(100000);  // sleeps for 1 second
        // } catch (InterruptedException e) {
        //     e.printStackTrace(); // or handle it properly
        // }

        Vehicle car1 = new FourWheelerVehicle("CAR-456");
        Ticket t2 = entryGate.parkVehicle(car1);

        // 3. Check availability
        System.out.println("Available two-wheeler spots: " +
                ParkingLot.getInstance().getAvailableSpotCount(VehicleType.TWO_WHEELER));
        System.out.println("Available four-wheeler spots: " +
                ParkingLot.getInstance().getAvailableSpotCount(VehicleType.FOUR_WHEELER));

        
        // try {
        //     Thread.sleep(100000);  // sleeps for 1 second
        // } catch (InterruptedException e) {
        //     e.printStackTrace(); // or handle it properly
        // }

        if(t1 != null) {
            double fee1 = exitGate.unparkVehicle(t1.getTicketId());
            System.out.println("Fee for bike1: " + fee1);
        }
        if (t2 != null) {
            double fee2 = exitGate.unparkVehicle(t2.getTicketId());
            System.out.println("Fee for car1: " + fee2);
        }

        // 5. After exit, check availability again
        System.out.println("Available two-wheeler spots after exit: " +
                ParkingLot.getInstance().getAvailableSpotCount(VehicleType.TWO_WHEELER));
        System.out.println("Available four-wheeler spots after exit: " +
                ParkingLot.getInstance().getAvailableSpotCount(VehicleType.FOUR_WHEELER));
    }
}
