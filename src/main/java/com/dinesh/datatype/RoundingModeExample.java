package com.dinesh.datatype;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingModeExample {
    public static void main(String[] args) {
        BigDecimal value1 = new BigDecimal("2.5");
        BigDecimal value2 = new BigDecimal("3.5");
        BigDecimal value3 = new BigDecimal("1.75");
        BigDecimal value4 = new BigDecimal("2.75");

        System.out.println("Value 1: " + value1.setScale(0, RoundingMode.HALF_EVEN)); // 2
        System.out.println("Value 2: " + value2.setScale(0, RoundingMode.HALF_EVEN)); // 4
        System.out.println("Value 3: " + value3.setScale(0, RoundingMode.HALF_EVEN)); // 2
        System.out.println("Value 4: " + value4.setScale(0, RoundingMode.HALF_EVEN)); // 2

        System.out.println("Value 1: " + new BigDecimal("2.3").setScale(0, RoundingMode.UP)); // 3
        System.out.println("Value 2: " + new BigDecimal("-2.3").setScale(0, RoundingMode.UP)); // -3

    }
}
