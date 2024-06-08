package com.dinesh.algorithm.dynamic_programming;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0 && i == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int top = 0;
                if(i - 1 >= 0)
                    top = dp[i - 1][j];
                int left = 0;
                if(j - 1 >= 0)
                    left = dp[i][j - 1];
                dp[i][j] = top + left;
            }
        }

        return dp[m - 1][n - 1];

    }
}
