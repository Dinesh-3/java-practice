package com.dinesh.algorithm.bit_manipulation;

public class CountNumberOfSetBits {
    public static void main(String[] args) {
        int number = 9;

        int countB = bruteForce(number);

        int countBetter = betterForce(number);
    }

    private static int betterForce(int number) {
        // at each step it will remove the last set bit
        int count = 0;
        while (number != 0) {
            number = number & number - 1;
            count++;
        }
        return count;
    }

    private static int bruteForce(int number) {
        int count = 0;
        while (number > 1) {
            count += number & 1;
            number = number >> 1;
        }
        return count;
    }
}
