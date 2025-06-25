package ParkingLotProblem.Components.MoneyCalculation;

public class Rate {
    private final double hourlyRate;
    private final double perMinuteRate;

    public Rate(double hourlyRate, double perMinuteRate) {
        this.hourlyRate = hourlyRate;
        this.perMinuteRate = perMinuteRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getPerMinuteRate() {
        return perMinuteRate;
    }
}
