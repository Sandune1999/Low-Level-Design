package ParkingLotProblem.Components.VehicleCompoenent;

import ParkingLotProblem.Components.VehicleType;

public class FourWheelerVehicle extends Vehicle {
    public FourWheelerVehicle(String vehicleNumber) {
        super(vehicleNumber, VehicleType.FOUR_WHEELER);
    }
}