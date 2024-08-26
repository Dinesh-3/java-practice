package com.dinesh.algorithm.math;

/**
 * Sum Of Cube of Number == Same Number
 * 371 => 3^3 + 7^3 + 1^3 == 371
 */
public class AmstrongNumber {
    public static void main(String[] args) {
        int number = 1634;

        int digit = number;

        double sum = 0;
        while (digit > 0) {

            int last = digit % 10;
            sum = Math.pow(last, 3) + sum;

            digit = digit / 10;
        }

        boolean result = sum == number;

        System.out.println("sum == number -> " + result);
    }
}
