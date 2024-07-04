package com.dinesh.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimePractice {
    public static void main(String[] args) {
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("IST Time: " + istTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        ZonedDateTime utcTime = istTime.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("UTC Time: " + utcTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }
}
