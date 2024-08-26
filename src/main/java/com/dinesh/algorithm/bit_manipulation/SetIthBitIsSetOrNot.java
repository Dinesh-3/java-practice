package com.dinesh.algorithm.bit_manipulation;

public class SetIthBitIsSetOrNot {
    public static void main(String[] args) {
        int n = 9;
        int ith = 2;

        /**
         * 8421
         * 1001
         *| 100
         * ----
         * 1101
         */

        System.out.println("n | (1 << ith) = " + (n | (1 << ith)));


        /**
         *
         * Clearing Ith bit using &
         * 8421
         * 1001
         *|0001
         * ----
         * 1000
         *
         * number & ~ (1 << 2) // also works
         *
         */

        System.out.println("n & (~(1 << 3)) = " + (n & (~(1 << 3))));

        /**
         *
         * Toggle Ith bit using xor ^
         * 8421
         * 1001
         *|0001
         * ----
         * 1000
         *
         *
         */
        System.out.println("(n ^ (1 << ith)) = " + (n ^ (1 << 3))); // 1

        /**
         *
         * Make Last set bit to zero
         *
         */

        System.out.println("(n & n-1) = " + (n & n-1));

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
