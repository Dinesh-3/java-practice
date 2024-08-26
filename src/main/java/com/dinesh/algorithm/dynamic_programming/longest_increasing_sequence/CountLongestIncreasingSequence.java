package com.dinesh.algorithm.dynamic_programming.longest_increasing_sequence;

import java.util.*;

/**
 *
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence
 *
 * https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/
 * https://www.youtube.com/watch?v=IFfYfonAFGc
 *
 */
public class CountLongestIncreasingSequence {

    static int longestSubsequenceBinarySearch(int n, int a[]) {
        List<Integer> list = new ArrayList<>();

        for(int num: a) {
            if(list.isEmpty()) {
                list.add(num);
                continue;
            }

            int last = list.get(list.size()-1);
            if(num > last) {
                list.add(num);
            } else {
                int low = 0;
                int high = list.size()-1;

                while(low <= high) {
                    int mid = (low + high) / 2;

                    if(list.get(mid) >= num) {
                        high = mid - 1;
                    }else {
                        low = mid + 1;
                    }
                }

                list.set(low, num);
            }
        }

        return list.size();

    }


    public int lengthOfLISDPApproachTwo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int max = 0;
        for(int num: dp)
            max = Math.max(max, num);

        return max;
    }

    public int lengthOfLISSpaceOptimization(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n+1];

        for(int i = n-1; i >= 0; i--) {
            int[] curr = new int[n+1];
            for(int j = i-1; j >= -1; j--) {
                int notTake = prev[j+1];
                int take = 0;
                if(j == -1 || nums[i] > nums[j])
                    take = 1 + prev[i+1];
                curr[j+1] = Math.max(notTake, take);
            }
            prev = curr;
        }

        return prev[0];
    }

    public int lengthOfLISTabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--) {
            for(int j = i-1; j >= -1; j--) {
                int notTake = dp[i+1][j+1];
                int take = 0;
                if(j == -1 || nums[i] > nums[j])
                    take = 1 + dp[i+1][i+1];
                dp[i][j+1] = Math.max(notTake, take);
            }
        }

        return dp[0][0];
    }


    public int lengthOfLIS(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        return lis(0, -1, nums, map);
    }

    private int lis(int index, int prevI, int[] nums, Map<String, Integer> map) {
        String key = index + "," + prevI;
        if(index == nums.length)
            return 0;

        if(map.containsKey(key))
            return map.get(key);

        int notTake = lis(index+1, prevI, nums, map);

        int take = 0;
        if(prevI == -1 || nums[index] > nums[prevI])
            take = 1 + lis(index+1, index, nums, map);
        map.put(key, Math.max(notTake, take));
        return Math.max(notTake, take);
    }

}
