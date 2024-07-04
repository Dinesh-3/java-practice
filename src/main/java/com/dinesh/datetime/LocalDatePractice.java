package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDatePractice {
    public static void main(String[] args) {
//        LocalDate policyStartDate = LocalDate.of(2022, 1, 1);
//        LocalDate effectiveDate = LocalDate.of(2021, 1, 1);

//        System.out.println("effectiveDate = " + effectiveDate.compareTo(policyStartDate.minusYears(3)));

//        System.out.println("LocalDate.now().minusYears(3) = " + LocalDate.now().minusYears(3));
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate policyStartDate = LocalDate.of(2022, 1, 2);
        LocalDate effectiveDate = LocalDate.of(2025, 1, 2);

        System.out.println("policyStartDate = " + policyStartDate.plusYears(3).minusDays(1));

//        System.out.println("policyStartDate = " + policyStartDate.plusYears(3).isBefore(effectiveDate));

        LocalDate now = LocalDate.now();
        LocalDateTime localDateTimeNow = LocalDateTime.now();

        LocalDate plusTwoDaysFromNow = LocalDate.now().plusDays(2);

        System.out.println("now = " + now);
        System.out.println("localDateTimeNow = " + localDateTimeNow);

        System.out.println("plusTwoDaysFromNow = " + plusTwoDaysFromNow);

        LocalDate date = LocalDate.of(2018, 9, 12);

        System.out.println("date = " + date);


        int number = 1000000;

        int result = (number * (number +1)) / 2;

        System.out.println("result = " + result);

        int sum = 0;

        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }

        System.out.println("sum = " + sum);
    }
}
