package com.dinesh.algorithm.dynamic_programming;

/**
 *
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 *
 */
public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int top = 0;
                    if(i - 1 >= 0)
                        top = dp[i - 1][j];
                    int left = 0;
                    if(j - 1 >= 0)
                        left = dp[i][j-1];

                    dp[i][j] = top + left;
                }
            }
        }

        return dp[m-1][n-1];

    }
}
