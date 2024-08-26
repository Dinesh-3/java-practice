package com.dinesh.algorithm.bit_manipulation;

public class BitManipulationMain {
    public static void main(String[] args) {
        /**
         *
         * 1's Complement
         *  (13) -> (1101)2 - FLIP -> (0010)2
         *
         *  2's Complement , Plus One to the 1's Complement
         *  --+1->
         *
         * 0010
         * 0001
         * ----
         * 0011
         *
         * Right Shift
         * 8 >> 3 ==> 8 / (2 to the power K) -> 1
         *
         * stored in last it 1_____0110
         * 0 -> For positive
         * 1 -> For Negative
         *
         * Negatives numbers are stored in form of 2's complement
         *  000000....1101
         *  111111....0010
         *              +1
         *  111111.1..0011
         *
         *  Left Shift Operator
         *  number << k -> number *  2^ k
         * (2^31-1) << k -> Overflow will happen
         *
         * NOT Operator -> ~
         *
         * X = ~ (5) -> -6
         *
         * Steps
         *
         * 1. Flip
         * 2. check is negative -> if yes 2's complement else stop
         *
         * X = ~ (-6) -> 5
         * 1. Convert 6 into 2's complement, since negatives are stored in 2's complement
         *
         */

        // Swap two numbers without using third variable
        int a = 4;
        int b = 3;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
