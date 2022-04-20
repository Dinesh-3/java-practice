package datetime;

import java.time.LocalDate;

public class LocalDatePractice {
    public static void main(String[] args) {
//        LocalDate policyStartDate = LocalDate.of(2022, 1, 1);
//        LocalDate effectiveDate = LocalDate.of(2021, 1, 1);

//        System.out.println("effectiveDate = " + effectiveDate.compareTo(policyStartDate.minusYears(3)));

//        System.out.println("LocalDate.now().minusYears(3) = " + LocalDate.now().minusYears(3));

        LocalDate policyStartDate = LocalDate.of(2022, 1, 2);
        LocalDate effectiveDate = LocalDate.of(2025, 1, 2);

        System.out.println("policyStartDate = " + policyStartDate.plusYears(3).minusDays(1).isBefore(effectiveDate));

//        System.out.println("policyStartDate = " + policyStartDate.plusYears(3).isBefore(effectiveDate));

    }
}
