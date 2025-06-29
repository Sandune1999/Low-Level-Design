package ElevatorDesign.Components;

import java.util.Map;

public class InternalDispatcher {
    private Map<Integer, ElevatorController> elevatorControllerMap;

    public InternalDispatcher() {
        this.elevatorControllerMap = ElevatorCreator.elevatorControllerMap;
    }

    public void internalRequest(int floor, ElevatorCar elevatorCar) {
        ElevatorController elevatorController = elevatorControllerMap.get(elevatorCar.getElevatorId());

        // ElevatorDirection direction;
        // if(elevatorCar.getCurrentFloor() < floor) {
        //     direction = ElevatorDirection.UP;
        // } else {
        //     direction = ElevatorDirection.DOWN;
        // }
        elevatorController.submitInternalRequest(floor, elevatorCar.getElevatorDirection());
    }
}
