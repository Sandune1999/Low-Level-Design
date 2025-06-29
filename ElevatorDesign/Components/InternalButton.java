package ElevatorDesign.Components;

public class InternalButton {
    private InternalDispatcher internalDispatcher;
    private int[] availableButtons = {1,2,3,4,5,6,7,8,9,10,11,12};
    private int selectedButton;

    public InternalButton() {
        internalDispatcher = new InternalDispatcher();
        selectedButton = -100;
    }

    public InternalDispatcher getInternalDispatcher() {
        return internalDispatcher;
    }

    public int[] getAvailableButtons() {
        return availableButtons;
    }

    public int getSelectedButton() {
        return selectedButton;
    }

    public void pressButton(int floor, ElevatorCar elevatorCar) {
        boolean isAvailable = false;
        for(int num:availableButtons) {
            if(num == floor) {
                isAvailable = true;
            }
        }

        if(!isAvailable) {
            System.out.println("Incorrect floor selected. Please Try again.");
            elevatorCar.pressButton();
        } 

        selectedButton = floor;
        
        internalDispatcher.internalRequest(floor, elevatorCar);
    }
}
