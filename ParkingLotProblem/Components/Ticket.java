package ParkingLotProblem.Components;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String vehicleNumber;
    private final String ticketId;
    private final VehicleType vehicleType;
    private final String spotId;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(String vehicleNumber, VehicleType vehicleType, String spotId) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        if(this.exitTime != null) {
            throw new IllegalStateException("Exit time is already moted on ticket.");
        }

        this.exitTime = exitTime;
    }
}
