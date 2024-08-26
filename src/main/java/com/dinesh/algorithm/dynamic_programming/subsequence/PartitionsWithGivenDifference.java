package com.dinesh.algorithm.dynamic_programming.subsequence;

/**
 *
 * Partitions with Given Difference
 * https://www.geeksforgeeks.org/problems/partitions-with-given-difference
 *
 * https://www.youtube.com/watch?v=zoilQD1kYSg
 *
 */
public class PartitionsWithGivenDifference {
    public static int countPartitions(int n, int d, int[] arr) {

        int totalSum = 0;
        for (int j : arr) totalSum += j;

        if(totalSum < d || (totalSum - d) % 2 == 1)
            return 0;

        int sum = (totalSum - d) / 2;

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

}
