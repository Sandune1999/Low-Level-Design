package StrategyDesignPattern;

public class Main {
    public static void main(String args[]) {
       
        // Vehicle obj = new GoodsVehicle();
        // obj.drive();

        Vehicle obj = new OffRoadVehicle();
        obj.drive();
    }
}
