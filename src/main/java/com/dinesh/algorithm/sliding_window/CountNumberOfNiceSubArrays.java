package com.dinesh.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1248. Count Number of Nice Subarrays
 * https://leetcode.com/problems/count-number-of-nice-subarrays
 *
 * https://www.youtube.com/watch?v=j_QOv9OT9Og
 *
 */
public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {

    }

    public int numberOfNiceSubarrays(int[] nums, int k) {
        int count = getSubArraysLessThanOrEqualToGoal(nums, k);
        int lessCount = getSubArraysLessThanOrEqualToGoal(nums, k - 1);
        return count - lessCount;
    }

    private int getSubArraysLessThanOrEqualToGoal(int[] nums, int goal) {
        if(goal < 0)
            return 0;

        int count = 0;
        int left = 0;
        int right = 0;

        int sum = 0;
        while(right < nums.length) {
            sum += nums[right] % 2;

            while(sum > goal)
                sum -= nums[left++] % 2;

            count += (right - left + 1);
            right++;
        }

        return count;

    }

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;

        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i] % 2;

            count += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
