package com.dinesh.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 992. Subarrays with K Different Integers
 * https://leetcode.com/problems/subarrays-with-k-different-integers
 *
 */
public class SubArrayWithKDifferentIntegers {

    public static void main(String[] args) {
        int[] nums = { 1,2,1,2,3 };
        int k = 2;

        SubArrayWithKDifferentIntegers array = new SubArrayWithKDifferentIntegers();
        array.subArraysWithKDistinct(nums, k);
    }

    public int subArraysWithKDistinct(int[] nums, int k) {
        int countK = getLessThanEqualK(nums, k);
        int countKMinus1 = getLessThanEqualK(nums, k-1);
        return countK - countKMinus1;
    }

    private int getLessThanEqualK(int[] nums, int k) {
        int left = 0;
        int right = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        while(right < nums.length) {
            int num = nums[right++];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while(map.size() > k ) {
                int leftNum = nums[left];
                map.put(leftNum, map.getOrDefault(leftNum, 0) - 1);
                if(map.get(leftNum) == 0)
                    map.remove(leftNum);
                left++;
            }

            count += ( right - left + 1 );
        }

        return count;

    }
}
