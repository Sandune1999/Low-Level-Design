package ParkingLotProblem;

import ParkingLotProblem.Components.ParkingExceptions.InvalidTicketException;

public class ExitGate {
    private final ParkingLot parkingLot;

    public ExitGate() {
        this.parkingLot = ParkingLot.getInstance();
    }

    /**
     * Attempt to unpark given ticketId; returns fee or -1 on failure.
     */
    public double unparkVehicle(String ticketId) {
        try {
            double fee = parkingLot.unparkVehicle(ticketId);
            System.out.println("Ticket: " + ticketId + " Exited. Fee: " + fee);
            
            return fee;
        } catch(InvalidTicketException e) {
            System.out.println("Unparking failed for ticket Id [" + ticketId + "]: " + e.getMessage());
            return -1;
        }
    }
}
