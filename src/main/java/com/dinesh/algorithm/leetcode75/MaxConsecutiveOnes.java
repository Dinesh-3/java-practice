package com.dinesh.algorithm.leetcode75;

/**
 * 1004. Max Consecutive Ones III
 * https://www.youtube.com/watch?v=3E4JBHSLpYk
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] numbers = { 0,0,0,1 };

        //longestOnesOof2N(numbers, 4);
        System.out.println("longestOnes(numbers, 4) = " + longestOnes(numbers, 4));
    }

    private static int longestOnes(int[] numbers, int k) {
        int startIndex = 0;
        int endIndex = 0;

        int maxCount = 0;

        int zerosCount = 0;

        while (endIndex < numbers.length) {
            if (numbers[endIndex] == 0)
                zerosCount++;

            if(zerosCount <= k)
                maxCount = Math.max(endIndex - startIndex + 1, maxCount);
            else if(numbers[startIndex++] == 0)
                zerosCount--;
            endIndex++;
        }

        return maxCount;
    }

    // O(2N)
    public static int longestOnesOof2N(int[] nums, int k) {

        int startIndex = 0;
        int endIndex = 0;

        int maxCount = 0;

        int zerosCount = 0;
        while(endIndex < nums.length) {
            if(nums[endIndex] == 1) {
                endIndex++;
            } else if (zerosCount < k) {
                endIndex++;
                zerosCount++;
            } else {
                maxCount = Math.max(maxCount, endIndex - startIndex );
                while (zerosCount >= k && startIndex < nums.length) {
                    if(nums[startIndex++] == 0 )
                        zerosCount--;
                }
            }
        }
        maxCount = Math.max(maxCount, endIndex - startIndex );
        return maxCount;
    }
}
