package com.dinesh.algorithm.stack;

import java.util.Stack;

/**
 *
 * 2104. Sum of Subarray Ranges
 * https://leetcode.com/problems/sum-of-subarray-ranges
 *
 * https://www.youtube.com/watch?v=gIrMptNPf5M
 *
 */
public class SumOfSubArrayRanges {
    public long subArrayRanges(int[] nums) {
        long[] mins = getMinContributions(nums);
        long[] maxs = getMaxContributions(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += maxs[i] - mins[i];
        }

        return sum;
    }

    private long[] getMinContributions(int[] nums) {
        int n = nums.length;
        long[] mins = new long[n];
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            mins[i] = (long) nums[i] * (i - left[i]) * (right[i] - i);
        }

        return mins;
    }

    private long[] getMaxContributions(int[] nums) {
        StringBuilder builder = new StringBuilder();
        
        int n = nums.length;
        long[] maxs = new long[n];
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxs[i] = (long) nums[i] * (i - left[i]) * (right[i] - i);
        }

        return maxs;
    }
}
