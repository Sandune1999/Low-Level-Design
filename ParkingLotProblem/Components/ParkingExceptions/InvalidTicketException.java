package ParkingLotProblem.Components.ParkingExceptions;

public class InvalidTicketException extends Exception {
    public InvalidTicketException(String message) {
        super(message);
    }
}
