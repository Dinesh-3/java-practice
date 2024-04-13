package com.dinesh.algorithm.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxAreaBruteForce(heights);
        int maxAreaEfficient = getMaxAreaEfficient(heights);
        System.out.println("maxAreaEfficient = " + maxAreaEfficient);
    }

    private static int getMaxAreaEfficient(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int height = Math.min(heights[leftPointer], heights[rightPointer]);

            maxArea = Math.max(maxArea, height * (rightPointer - leftPointer));
            if(heights[leftPointer] <= heights[rightPointer]) {
                leftPointer++;
            }else {
                rightPointer--;
            }
        }

        return maxArea;
    }

    public static int maxAreaBruteForce(int[] height) {
        int maxWaterAmount = 0;

        for (int i = 0; i < height.length; i++) {
            int leftHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int rightHeight = height[j];
                int levelHeight = Math.min(leftHeight, rightHeight);
                int levelWidth = j - i;
                int waterAmount = levelHeight * levelWidth;
                maxWaterAmount = Math.max(waterAmount, maxWaterAmount);
            }
        }

        return maxWaterAmount;
    }
}
