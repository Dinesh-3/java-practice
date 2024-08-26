package com.dinesh.algorithm.dynamic_programming.longest_increasing_sequence;

import java.util.Arrays;

/**
 *
 * 673. Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence
 *
 * https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/
 * https://www.youtube.com/watch?v=cKVl1TFdNXg
 *
 */
public class NumberOfLongestIncreasingSubSequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] count = new int[n];
        Arrays.fill(count, 1);

        int max = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int len = dp[j] + 1;
                if(nums[j] < nums[i]) {
                    if(len > dp[i]) {
                        dp[i] = len;
                        count[i] = count[j];
                    } else if(len == dp[i]) {
                        count[i] += count[j];
                    }
                }
                max = Math.max(dp[i], max);
            }
        }

        int total = 0;
        for(int i = 0; i < n; i++)
            if(dp[i] == max)
                total += count[i];

        return total == 0 ? 1 : total;
    }

}
