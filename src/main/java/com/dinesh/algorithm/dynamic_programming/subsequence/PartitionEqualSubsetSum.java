package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum
 *
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums)
            totalSum += num;
        if(totalSum % 2 == 1)
            return false;

        int target = totalSum / 2;

        Map<String, Boolean> map = new HashMap<>();

        return isPossible(nums.length - 1, target, nums, map);
    }

    private static boolean isPossible(int index, int target, int[] nums, Map<String, Boolean> map) {
        String key = index + "," + target;
        if(target == 0)
            return true;

        if(index == 0)
            return nums[index] == target;

        if(map.containsKey(key))
            return map.get(key);

        boolean notPick = isPossible(index - 1, target, nums, map);
        boolean pick = false;

        if(nums[index] <= target)
            pick = isPossible(index - 1, target - nums[index], nums, map);

        map.put(key, notPick || pick);
        return notPick || pick;
    }

    public boolean canPartitionTabulation(int[] nums) {

        int totalSum = 0;
        for(int num: nums)
            totalSum += num;
        if(totalSum % 2 == 1)
            return false;

        int target = totalSum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n; i++)
            dp[i][0] = true;
        for(int i = 1; i < n; i++) {
            for(int t = 1; t <= target; t++) {
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(nums[i] <= t)
                    take = dp[i-1][t-nums[i]];
                dp[i][t] = notTake || take;
            }
        }

        return dp[n-1][target];
    }

}
