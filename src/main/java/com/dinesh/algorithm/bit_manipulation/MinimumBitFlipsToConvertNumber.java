package com.dinesh.algorithm.bit_manipulation;

/**
 *
 * 2220. Minimum Bit Flips to Convert Number
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 *
 * https://www.youtube.com/watch?v=OOdrmcfZXd8
 *
 */
public class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;

        int count = 0;

        while(xor != 0) {
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;

    }

}
