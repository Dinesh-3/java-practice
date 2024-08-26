package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        combinationSum(0, sum, candidates, target, result, stack);
        return result;
    }

    private void combinationSum(int index, int sum, int[] candidates, int target, List<List<Integer>> result, Stack<Integer> stack) {
        if(index == candidates.length) {
            if(target == sum)
                result.add(new ArrayList<>(stack));
            return;
        }
        if(index >= candidates.length || sum > target)
            return;
        stack.push(candidates[index]);
        combinationSum(index, sum + candidates[index], candidates, target, result, stack);
        stack.pop();
        combinationSum(index + 1, sum, candidates, target, result, stack);
    }

    public int perfectSum(int[] arr,int n, int sum)
    {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int j = 1; j <= sum; j++)
            dp[0][j] = 0;

        int mod = (int) 1e9+7;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]) % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j]) % mod;
                }
            }
        }

        return dp[n][sum];

    }


}
