package datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class PeriodPractice {
    public static void main(String[] args) {
        Period period = Period.of(3, 11, 20);
        int months = period.getMonths();
        System.out.println("months = " + months); // 11

        long totalMonths = period.toTotalMonths(); // 47

        System.out.println("totalMonths = " + totalMonths);

        Period between = Period.between(LocalDate.of(2020, 7, 1), LocalDate.now());
        between.getDays();
        between.getMonths();
        between.getYears();
//        for (TemporalUnit unit : between.getUnits()) {
//            System.out.println("unit = " + unit);
//        }

        System.out.println("Period between " + between);

        LocalDate startDate = LocalDate.of(2001, 12, 31);
        LocalDate endDate = LocalDate.of(2004, 12, 31);

        System.out.println("ChronoUnit.DAYS.between(startDate, endDate) = " + ChronoUnit.DAYS.between(startDate, endDate));
        Duration duration = ChronoUnit.DAYS.getDuration();
        System.out.println("duration DAYS = " + duration);
        int periodInYears = Period.between(startDate, endDate).getYears();

        System.out.println("periodInYears = " + periodInYears);

        System.out.println("endDate minusYears = " + endDate.minusYears(3));
        System.out.println("endDate minusYears = " + endDate.minusYears(3).isAfter(startDate));

        System.out.println("Period.ofYears(1) = " + Period.ofYears(1));

    }
}
