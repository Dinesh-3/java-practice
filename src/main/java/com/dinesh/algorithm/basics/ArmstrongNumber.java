package com.dinesh.algorithm.basics;

/**
 *
 *  371 => 3^3 + 7^3 + 1^3 -> 371
 *  if cube of digits produces the same number
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 371;

        int sum = 0;

        int digits = num;

        while (digits > 0) {
            int mod = digits % 10;
            sum += (int) Math.pow(mod, 3);
            digits = digits / 10;
        }

        System.out.println("sum = " + sum);

    }
}
