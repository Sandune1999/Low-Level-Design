package ParkingLotProblem.Components.ParkingExceptions;

public class NoAvailableSpotException extends Exception {
    public NoAvailableSpotException(String message) {
        super(message);
    }
}
