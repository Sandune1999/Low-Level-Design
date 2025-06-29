package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

import ElevatorDesign.Components.Building;
import ElevatorDesign.Components.ElevatorDirection;
import ElevatorDesign.Components.Floor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Lift Lobby.");
        List<Floor> floorList = new ArrayList<>();
        Floor floor0 = new Floor(0);
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        Floor floor6 = new Floor(6);
        Floor floor7 = new Floor(7);
        floorList.add(floor0);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);
        floorList.add(floor6);
        floorList.add(floor7);

        Building building = new Building(floorList);

        System.out.println("Lift will come in few seconds.");

        floor0.pressButton(ElevatorDirection.UP);


        // Runnable task1 = () -> {
        //     floor0.pressButton(ElevatorDirection.UP);
        //     try {
        //         Thread.sleep(7000);
        //     } catch (InterruptedException e) {

        //     }
        // };

        // Runnable task2 = () -> {
        //     floor4.pressButton(ElevatorDirection.DOWN);
        //     try {
        //         Thread.sleep(7000);
        //     } catch (InterruptedException e) {
                
        //     }
        // };

        // Runnable task3 = () -> {
        //     floor3.pressButton(ElevatorDirection.UP);
        //     try {
        //         Thread.sleep(7000);
        //     } catch (InterruptedException e) {
                
        //     }
        // };

        // Thread t1 = new Thread(task1, "T1");
        // Thread t2 = new Thread(task2, "T2");
        // Thread t3 = new Thread(task3, "T3");

        // t1.start();
        // t2.start();
        // t3.start();

        // // Optionally wait for all to finish
        // try {
        //     t1.join();
        //     t2.join();
        //     t3.join();
        // } catch (InterruptedException e) {
        //     Thread.currentThread().interrupt();
        //     System.out.println("Main thread was interrupted.");
        // }
    }
}
