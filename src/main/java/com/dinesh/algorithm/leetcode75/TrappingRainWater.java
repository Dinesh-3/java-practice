package com.dinesh.algorithm.leetcode75;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = { 1,8,6,2,5,4,8,3,7 };

        maxArea(heights);
    }
    public static int maxArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int minIndex = heights[leftPointer] < heights[rightPointer] ? leftPointer : rightPointer;
            maxArea = Math.max(((rightPointer - leftPointer) * heights[minIndex]), maxArea);

            if(heights[leftPointer] < heights[rightPointer])
                leftPointer++;
            else
                rightPointer--;
        }

        return maxArea;
    }
}
