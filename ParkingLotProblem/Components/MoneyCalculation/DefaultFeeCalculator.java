package ParkingLotProblem.Components.MoneyCalculation;

import java.time.Duration;
import java.time.LocalDateTime;

public class DefaultFeeCalculator implements FeeCalculator {
    @Override
    public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, Rate rate) {
        if(entryTime == null || exitTime == null || rate == null) {
            throw new IllegalArgumentException("Argument can not be null.");
        }

        if(exitTime.isBefore(entryTime)) {
            throw new IllegalArgumentException("exitTime can not smaller then entryTime.");
        }

        Duration duration = Duration.between(entryTime, exitTime);
        long totalMinute = duration.toMinutes();
        long hours = totalMinute/60;
        long minutes = totalMinute%60;

        return hours*rate.getHourlyRate() + minutes*rate.getPerMinuteRate();
    }
}
