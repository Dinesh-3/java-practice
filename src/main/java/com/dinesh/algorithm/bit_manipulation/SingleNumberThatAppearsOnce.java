package com.dinesh.algorithm.bit_manipulation;

/**
 *
 * 136. Single Number
 * https://leetcode.com/problems/single-number
 *
 */
public class SingleNumberThatAppearsOnce {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for(int num : nums)
            xor ^= num;
        return xor;
    }
}
