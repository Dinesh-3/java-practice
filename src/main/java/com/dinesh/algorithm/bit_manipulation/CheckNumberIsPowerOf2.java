package com.dinesh.algorithm.bit_manipulation;

public class CheckNumberIsPowerOf2 {
    public static void main(String[] args) {
        int n = 8;
        /**
         *
         * Check if the number is power of 2
         *
         * 8 is power of 2 -> 2 * 2 * 2 => 8
         * which will have single only one set bit
         */

        System.out.println("n & n-1 == 0 = " +( (n & n - 1) == 0));

    }
}
