package com.dinesh.algorithm.dynamic_programming;

/**
 *
 * Subset Sum Problem
 * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638
 *
 * Subset sum equal to target (DP- 14)
 * https://www.youtube.com/watch?v=fWX9xDmIzRI
 *
 */
public class SubsetSumProblem {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N][sum+1];

        for(int i = 0; i < N; i++)
            dp[i][0] = true;

        if(arr[0] <= sum)
            dp[0][arr[0]] = true;

        for(int i = 1; i < arr.length; i++) {
            for(int t=0; t <= sum; t++) {
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(t >= arr[i])
                    take = dp[i-1][t-arr[i]];
                dp[i][t] = notTake || take;
            }
        }

        return dp[N-1][sum];
    }
}
