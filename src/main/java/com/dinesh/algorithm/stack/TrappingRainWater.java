package com.dinesh.algorithm.stack;


import java.util.Stack;

/**
 *
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water
 *
 * https://www.youtube.com/watch?v=m18Hntz4go8
 * https://takeuforward.org/data-structure/trapping-rainwater/
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = height.length - 1;

        int water = 0;

        while (l < r) {
            int collected = 0;
            if (height[l] < height[r]) {
                collected = leftMax - height[l];
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                collected = rightMax - height[r];
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }

            if (collected > 0)
                water += collected;
        }
        return water;
    }

    static int trapRainWater(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}