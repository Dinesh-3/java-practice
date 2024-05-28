package com.dinesh.algorithm.sliding_window;

/**
 * 930. Binary Subarrays With Sum
 * https://leetcode.com/problems/binary-subarrays-with-sum
 *
 *
 */
public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        int[] nums = { 1,0,1,0,1 };
        int goal = 2;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = getSubArraysLessThanOrEqualToGoal(nums, goal);
        int lessCount = getSubArraysLessThanOrEqualToGoal(nums, goal - 1);
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
            sum += nums[right];

            while(sum > goal)
                sum -= nums[left++];
            count += (right - left) + 1;
            right++;
        }

        return count;

    }

}
