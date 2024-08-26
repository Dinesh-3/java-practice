package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Perfect Sum Problem
 * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633
 *
 */
public class CountSubsetSumWithSumK {


    public int perfectSumTabulation(int[] arr,int n, int sum)
    {
        int MOD = 1000000007;
        int[][] dp = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int t = 0; t <= sum; t++) {
                int notTake = dp[i-1][t];
                int take = 0;
                if (arr[i-1] <= t)
                    take = dp[i-1][t - arr[i-1]];
                dp[i][t] = (notTake + take) % MOD;
            }
        }

        return dp[n][sum];
    }

    int MOD = 1000000007;
    public int perfectSum(int[] arr,int n, int sum)
    {
        Map<String, Integer> map = new HashMap<>();
        return perfectSum(0, 0, arr, n, sum, map);
    }

    public int perfectSum(int index, long currentSum, int arr[],int n, int sum, Map<String, Integer> map)
    {
        String key = index + "," + currentSum;
        if(currentSum > sum)
            return 0;
        if(index >= n)
            return currentSum == sum ? 1 : 0;
        if(map.containsKey(key))
            return map.get(key);
        int left = perfectSum(index+1, currentSum + arr[index], arr, n, sum, map);
        int right = perfectSum(index+1, currentSum, arr, n, sum, map);
        int count = (left + right) % MOD;
        map.put(key, count);
        return count;
    }
}
