package com.dinesh.algorithm.array;

import java.util.Arrays;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));
        System.out.println("maxSubArray(nums, 1) = " + Arrays.toString(maxSubArray(nums, 1)));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int num : nums) {
            if (sum < 0)
                sum = 0;
            sum += num;
            max = Math.max(sum, max);
        }

        return max;
    }

    public static int[] maxSubArray(int[] nums, int res) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum == 0)
                startIndex = i;
            sum += nums[i];
            if(sum > max) {
                max = sum;
                endIndex = i;
            }

            if(sum < 0) {
                sum = 0;
            }
        }

        int[] result = new int[endIndex - startIndex + 1];
        for (int i = 0; i <result.length; i++) {
            result[i] = nums[i + startIndex];
        }
        return result;
    }
}
