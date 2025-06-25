package ParkingLotProblem.Components.VehicleCompoenent;

import ParkingLotProblem.Components.VehicleType;

public abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;

    Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
