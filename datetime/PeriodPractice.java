package datetime;

import java.time.Period;

public class PeriodPractice {
    public static void main(String[] args) {
        Period period = Period.of(3, 11, 20);
        int months = period.getMonths();
        System.out.println("months = " + months); // 11

        long totalMonths = period.toTotalMonths(); // 47

        System.out.println("totalMonths = " + totalMonths);
    }
}
