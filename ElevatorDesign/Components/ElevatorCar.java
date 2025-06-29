package ElevatorDesign.Components;

import java.util.Scanner;

public class ElevatorCar {
    private final int id;
    private ElevatorDisplay display;
    private int currentFloor;
    private ElevatorStatus status;
    private InternalButton internalButton;
    private ElevatorDoor door;
    private ElevatorDirection direction;

    public ElevatorCar(int id) {
        this.id = id;
        this.display = new ElevatorDisplay(0, ElevatorDirection.UP);
        this.currentFloor = 0;
        this.status = ElevatorStatus.IDLE;
        this.internalButton = new InternalButton();
        this.door = new ElevatorDoor();
        this.direction = ElevatorDirection.UP;
    }

    public ElevatorDirection getElevatorDirection() {
        return direction;
    }

    public void setElevatorDirection(ElevatorDirection direction) {
        this.direction = direction;
    }

    public int getElevatorId() {
        return id;
    }

    public void showElevatorDisplay() {
        display.showDisplay();
    }

    public void setElevatorDisplay() {
        display.setFloor(currentFloor);
        display.setElevatorDirection(direction);
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setElevatorStatus(ElevatorStatus status) {
        this.status = status;
    }

    public ElevatorStatus getElevatorStatus() {
        return status;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public ElevatorDoor getElevatorDoor() {
        return door;
    }

    @SuppressWarnings("resource")
    public void pressButton() {
        System.out.println("Enter the floor which you want to go.");
        Scanner scanner = new Scanner(System.in);
        int choosenFloor = scanner.nextInt();

        // if(currentFloor < choosenFloor) {
        //     direction = ElevatorDirection.UP;
        // } else {
        //     direction = ElevatorDirection.DOWN;
        // }
        internalButton.pressButton(choosenFloor, this);
    }

    boolean moveElevator(ElevatorDirection direction, int destinationFloor) {
        int startFloor = currentFloor;

        if(direction == ElevatorDirection.UP) {
            for(int i = startFloor; i < destinationFloor; i++) {
                this.currentFloor = i;
                setElevatorDisplay();
                showElevatorDisplay();
                try {
                    Thread.sleep(800);
                } catch(Exception e) {
                    //
                }

                if(i == destinationFloor) {
                    return true;
                }
            }
        }

        if(direction == ElevatorDirection.DOWN) {
            for(int i = startFloor; i > destinationFloor; i--) {
                this.currentFloor = i;
                setElevatorDisplay();
                showElevatorDisplay();

                try {
                    Thread.sleep(800);
                } catch(Exception e) {
                    //
                }


                if(i == destinationFloor) {
                    return true;
                }
            }
        }

        return false;
    }
}
