package ElevatorDesign.Components;

public class Floor {
    private final int floorNumber;
    private ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(ElevatorDirection direction) {
        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }
}
