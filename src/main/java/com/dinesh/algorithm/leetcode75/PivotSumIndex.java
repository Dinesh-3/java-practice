package com.dinesh.algorithm.leetcode75;

/**
 * 724. Find Pivot Index
 */
public class PivotSumIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(currentSum == (sum - currentSum - nums[i]))
                return i;
            currentSum += nums[i];
        }

        return -1;
    }
}
