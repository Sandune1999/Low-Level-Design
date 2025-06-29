package ElevatorDesign.Components;

import java.util.Map;

public class ExternalDispatcher {
    private Map<Integer, ElevatorController> elevatorControllerMap;

    public ExternalDispatcher() {
        this.elevatorControllerMap = ElevatorCreator.elevatorControllerMap;
    }

    public Map<Integer, ElevatorController> getElevatorContrMap() {
        return elevatorControllerMap;
    }

    public void submitExternalRequest(int floor, ElevatorDirection direction) {

        for(ElevatorController controller: elevatorControllerMap.values()) {
            int elevatorId = controller.getElevatorCar().getElevatorId();

            if(floor%2 == 1 && elevatorId%2 == 1) {
                controller.submitExternalRequest(floor, direction);
            } else if(floor%2 == 0 && elevatorId%2 == 0) {
                controller.submitExternalRequest(floor, direction);
            }
        }
    }
}
