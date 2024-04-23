package com.dinesh.algorithm.leetcode75;

/**
 * 643. Maximum Average Subarray I
 *
 * Approach Sliding Window
 */
public class MaxAverageSubArray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        double maxAverage = findMaxAverageBruteForce(nums, 4);
        System.out.println("maxAverage = " + maxAverage);

        double max = findMaxAverage(nums, 4);
    }

    private static double findMaxAverage(int[] nums, int len) {
        int sum = 0;

        for (int i = 0; i < len; i++)
            sum += nums[i];

        int maxSum = sum;
        int startIndex = 0;
        int endIndex = len;

        while (endIndex < nums.length) {
            sum -= nums[startIndex++];
            sum += nums[endIndex++];
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum / (double) len;
//        double maxAverage = 0;
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(i > len - 1) {
//                double average = sum / (double) len;
//                if(average > maxAverage)
//                    maxAverage = average;
//                sum = sum - nums[i - len];
//                sum = sum + nums[i];
//            } else {
//                sum += nums[i];
//            }
//        }

    }

    public static double findMaxAverageBruteForce(int[] nums, int k) {

        double maxAverage = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                int length = j - i + 1;
                if(length != k)
                    continue;
                double average = (double) sum / ( j - i + 1);
                if(average > maxAverage)
                    maxAverage = average;
            }
        }

        return maxAverage;

    }
}
