package datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodPractice {
    public static void main(String[] args) {
        Period period = Period.of(3, 11, 20);
        int months = period.getMonths();
        System.out.println("months = " + months); // 11

        long totalMonths = period.toTotalMonths(); // 47

        System.out.println("totalMonths = " + totalMonths);

        Period between = Period.between(LocalDate.of(2020, 7, 1), LocalDate.now());

        LocalDate startDate = LocalDate.of(2001, 12, 31);
        LocalDate endDate = LocalDate.of(2004, 12, 31);

        System.out.println("ChronoUnit.DAYS.between(startDate, endDate) = " + ChronoUnit.DAYS.between(startDate, endDate));

        int periodInYears = Period.between(startDate, endDate).getYears();

        System.out.println("periodInYears = " + periodInYears);

        System.out.println("between " + between);

        System.out.println("endDate minusYears = " + endDate.minusYears(3));
        System.out.println("endDate minusYears = " + endDate.minusYears(3).isAfter(startDate));

        System.out.println("Period.ofYears(1) = " + Period.ofYears(1));

    }
}
