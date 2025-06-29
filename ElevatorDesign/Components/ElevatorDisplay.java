package ElevatorDesign.Components;

public class ElevatorDisplay {
    private int floor;
    private ElevatorDirection direction;

    public ElevatorDisplay(int floor, ElevatorDirection direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setElevatorDirection(ElevatorDirection direction) {
        this.direction = direction;
    }

    public ElevatorDirection getElevatorDirection() {
        return direction;
    }

    public void showDisplay() {
        System.out.println("Current floor:- " + floor + " and direction is " + direction);
        // if(direction == ElevatorDirection.UP) {
            
        // } else {
        //     System.out.println("Current floor:- " + floor + " and direction is ");
        // }
        
    }
}
