package ElevatorDesign.Components;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class ElevatorController {
    private PriorityQueue<Integer> upMinPQ;
    private PriorityQueue<Integer> downMaxPQ;
    private Queue<Integer> queue;
    private final ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar) {
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b - a);
        queue = new LinkedList<>();
        this.elevatorCar = elevatorCar;
    }
    
    public PriorityQueue<Integer> getUpMinPQ() {
        return upMinPQ;
    }

    public PriorityQueue<Integer> getDownMAxPQ() {
        return downMaxPQ;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public void submitInternalRequest(int floor, ElevatorDirection direction) {
        if(direction == ElevatorDirection.DOWN) {//elevator is going down
            if(floor < elevatorCar.getCurrentFloor()) {
                downMaxPQ.offer(floor);
            } else {
                queue.add(floor);
            }
        } else {
            if(floor > elevatorCar.getCurrentFloor()) {//elevator is going up
                upMinPQ.offer(floor);
            } else {
                queue.add(floor);
            }
        }

        controlElevator();
    }

    public void submitExternalRequest(int floor, ElevatorDirection direction) {
        if(direction == ElevatorDirection.DOWN) {//elevator is going down
            if(floor <= elevatorCar.getCurrentFloor()){
                downMaxPQ.offer(floor);
            } else {
                queue.add(floor);
            }
            
        } else {
            if(floor >= elevatorCar.getCurrentFloor()) {//elevator is going up
                upMinPQ.offer(floor);
            } else {
                queue.add(floor);
            }
        }

        controlElevator();
    }

    public void controlElevator() {
        while (true) {
            while(!upMinPQ.isEmpty()) {//elevator is going up
                int floor = upMinPQ.poll();

                elevatorCar.moveElevator(ElevatorDirection.UP, floor);

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    //
                }
                elevatorCar.getElevatorDoor().openDoor();
                System.out.println("for floor: " + floor);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }

                //If anybody wants to get out or hop on in elevator car they can in this duration
                //suppose a person hops on in elevator
                elevatorCar.pressButton();
                elevatorCar.getElevatorDoor().closeDoor();

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }
            }

            //Now we have to change the direction of elevator, from up to down because all up request are fullfilled
            elevatorCar.setElevatorDirection(ElevatorDirection.DOWN);

            while(!queue.isEmpty()) {
                downMaxPQ.add(queue.poll());
            }

            while(!downMaxPQ.isEmpty()) {//elevator is going down
                int floor = downMaxPQ.poll();

                elevatorCar.moveElevator(ElevatorDirection.DOWN, floor);

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    //
                }
                elevatorCar.getElevatorDoor().openDoor();
                System.out.println("for floor: " + floor);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }

                //If anybody wants to get out or hop on in elevator car they can in this duration
                //suppose a person hops on in elevator
                elevatorCar.pressButton();
                elevatorCar.getElevatorDoor().closeDoor();

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    //
                }
            }

            //Now we have to change the direction of elevator, from down to up because all down request are fullfilled
            elevatorCar.setElevatorDirection(ElevatorDirection.UP);

            while(!queue.isEmpty()) {
                upMinPQ.add(queue.poll());
            }

            if(upMinPQ.isEmpty() && downMaxPQ.isEmpty() && queue.isEmpty()) break;
        }
    }
}
