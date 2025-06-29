package ElevatorDesign.Components;

import java.util.HashMap;
import java.util.Map;

public class ElevatorCreator {
    static Map<Integer, ElevatorController> elevatorControllerMap = new HashMap<>();
    static {
        ElevatorCar elevatorCar1 = new ElevatorCar(1);
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);
        elevatorControllerMap.put(elevatorCar1.getElevatorId(), elevatorController1);

        ElevatorCar elevatorCar2 = new ElevatorCar(2);
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);
        elevatorControllerMap.put(elevatorCar2.getElevatorId(), elevatorController2);
    }
}
