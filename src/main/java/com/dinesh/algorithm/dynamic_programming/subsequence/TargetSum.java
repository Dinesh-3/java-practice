package com.dinesh.algorithm.dynamic_programming.subsequence;

/**
 *
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 *
 * Target Sum (DP - 21)
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 * https://www.youtube.com/watch?v=b3GD8263-PQ
 *
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int diff) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums)
            totalSum += num;

        if(totalSum < diff || (totalSum - diff) % 2 == 1)
            return 0;

        int target = (totalSum - diff) / 2;

        int[][] dp = new int[n+1][target+1];

        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int t = 0; t <= target; t++) {
                int take = 0;
                if(nums[i-1] <= t)
                    take = dp[i-1][t-nums[i-1]];
                int notTake = dp[i-1][t];

                dp[i][t] = take + notTake;
            }
        }

        return dp[n][target];

    }

}
