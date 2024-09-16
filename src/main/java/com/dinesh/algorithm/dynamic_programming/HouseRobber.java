package com.dinesh.algorithm.dynamic_programming;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber
 *
 * https://www.youtube.com/watch?v=GrMBfJNk_NY
 *
 */
public class HouseRobber {

    public int robSpaceOptimization(int[] nums) {
        int n = nums.length;

        int prevOne = nums[0];
        int prevTwo = 0;

        for(int index = 1; index< n; index++) {
            int pick = nums[index];
            if(index - 2 >= 0)
                pick += prevTwo;
            int notPick = prevOne;
            prevTwo = prevOne;
            prevOne = Math.max(pick, notPick);
        }

        return prevOne;
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++) {
            int pik = nums[i];
            if(i - 2 >= 0)
                pik += dp[i - 2];
            int notPik = dp[i - 1];

            dp[i] = Math.max(pik, notPik);
        }

        return dp[nums.length - 1];
    }

    public int rob(int index, int[] nums, int[] dp) {
        if(index == 0)
            return nums[index];
        if(index < 0)
            return 0;
        if(dp[index] != 0)
            return dp[index];

        int pik = nums[index];
        if(index - 2 >= 0)
            pik += rob(index - 2, nums, dp);
        int notPik = 0 + rob(index - 1, nums, dp);

        dp[index] = Math.max(pik, notPik);
        return dp[index];
    }
}
