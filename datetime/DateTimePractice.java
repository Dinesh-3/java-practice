package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

public class DateTimePractice {
    public static void main(String[] args) {
        /**
         * java.time -> Immutable date object and Thread Safe
         * Provider -> Joda-Time (Stephen Colebourne)
         */
        /**
         * Leap Year => Comes every four year
         * https://spaceplace.nasa.gov/leap-year/en/
         * It takes approximately 365.25 days for Earth to orbit the Sun — a solar year.
         * We usually round the days in a calendar year to 365.
         * To make up for the missing partial day, we add one day to our calendar approximately every four years.
         * That is a leap year.
         *    - <- GMT -> +
         * GMT -> Greenwich Mean Time (England)
         * 1 Hour -> 15 degree
         * 24 Hour -> 24*15 = 360 degree
         * India -> + 5.5
         */

        Date date = new Date();
        String s = date.toString();
//        System.out.println("s = " + s);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate TODAY_DATE = LocalDate.now();
        System.out.println("TODAY DATE WITH dd-MM-yyyy FORMAT: " + TODAY_DATE.format(formatter));
        LocalDate.of(2020,2,29);
        final byte DAY = (byte) TODAY_DATE.getDayOfMonth();
        final byte MONTH = (byte) TODAY_DATE.getMonthValue();
        final int YEAR = TODAY_DATE.getYear();

        System.out.println("isLeapYear() = " + TODAY_DATE.isLeapYear());
        System.out.println("DAY = " + DAY);
        System.out.println("MONTH = " + MONTH);
        System.out.println("YEAR = " + YEAR);

        /**
         * Milli -> 10 ^ -3 => 1 / 1000
         * Micro -> 10 ^ -6
         * Nano -> 10 ^ -9
         * Pico -> 10 ^ -12
         * Femto -> 10 ^ -15
         */

        final LocalTime CURRENT_TIME = LocalTime.now();
        int hour = CURRENT_TIME.getHour();
        int minute = CURRENT_TIME.getMinute();
        int second = CURRENT_TIME.getSecond();
        int nano = CURRENT_TIME.getNano();

        System.out.println("CURRENT_TIME = " + CURRENT_TIME);
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("nano = " + nano);

//        while (true) {
//            try {
//                Thread.sleep(1000);
//                System.out.println("LocalTime.now().getSecond() = " + LocalTime.now().getSecond());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


        LocalDateTime DATE_TIME_NOW = LocalDateTime.now();
        int dayOfMonth = DATE_TIME_NOW.getDayOfMonth();
        int hour1 = DATE_TIME_NOW.getHour();

        System.out.println("hour1 = " + hour1);
        System.out.println("dayOfMonth = " + dayOfMonth);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm:ss");
        DATE_TIME_NOW.format(timeFormatter);
        System.out.println("DATE_TIME_NOW = " + DATE_TIME_NOW.format(timeFormatter));

        LocalDateTime plusOneMonths = DATE_TIME_NOW.plusMonths(1);
        LocalDateTime minusOneMonths = DATE_TIME_NOW.minusMonths(1);
        LocalDate getDateObject = DATE_TIME_NOW.toLocalDate();

//        Find Date Range
        boolean before = DATE_TIME_NOW.isBefore(plusOneMonths);
        boolean after = DATE_TIME_NOW.isAfter(plusOneMonths);
        System.out.print("after = " + after + "before = " + before + "\n");

        LocalDateTime withed = DATE_TIME_NOW.withMonth(12); //immutable returns new LocalDateTime
        System.out.println("withed = " + withed);

        Month january = Month.JANUARY;

        System.out.println("getDateObject = " + getDateObject);
        System.out.println("plusOneMonths = " + plusOneMonths);
        System.out.println("minusOneMonths = " + minusOneMonths);

//        ZONES
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        int totalZones = availableZoneIds.size();
        System.out.println("totalZones = " + totalZones);
    }
}
