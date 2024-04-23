package com.dinesh.algorithm.leetcode75;

public class LongestSubArrayOfOnesAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] numbers = {0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1};

        System.out.println("longestSubArray(numbers) = " + longestSubArray(numbers));

    }

    private static int longestSubArray(int[] numbers) {
        int maxLength = 0;

        int leftIndex = 0;
        int rightIndex = 0;

        int removeCount = 0;

        while (rightIndex < numbers.length) {
            if(numbers[rightIndex] == 0)
                removeCount++;

            if(removeCount <= 1)
                maxLength = Math.max(rightIndex - leftIndex + 1, maxLength);
            else if(numbers[leftIndex++] == 0)
                removeCount--;

            rightIndex++;

        }

        return --maxLength;

    }
}
