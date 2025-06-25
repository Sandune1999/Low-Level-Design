package ParkingLotProblem.Components.MoneyCalculation;

import java.time.LocalDateTime;

public interface FeeCalculator {
    double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, Rate rate);
}
