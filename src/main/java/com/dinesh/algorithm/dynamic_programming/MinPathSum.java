package com.dinesh.algorithm.dynamic_programming;


/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * https://www.youtube.com/watch?v=_rgTlyky1uQ
 * https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/
 *
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        int minSum = Integer.MAX_VALUE;
        return minPathSum(r - 1, c - 1, grid, dp);
    }
    public int minPathSum(int r, int c, int[][] grid, int[][] dp) {
        if(r == 0 && c == 0)
            return grid[r][c];
        if(r < 0 || c < 0)
            return (int) Math.pow(10, 9);
        if(dp[r][c] != 0)
            return dp[r][c];

        int top = grid[r][c] + minPathSum(r - 1, c, grid, dp);
        int left = grid[r][c] + minPathSum(r, c - 1, grid, dp);

        dp[r][c] = Math.min(top, left);
        return dp[r][c];
    }

    public void tabulation(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i == 0 && j == 0)
                    dp[0][0] = grid[i][j];
                else {
                    int top = Integer.MAX_VALUE;
                    if(i - 1 >= 0)
                        top = grid[i][j] + dp[i-1][j];
                    int left = Integer.MAX_VALUE;
                    if(j - 1 >= 0)
                        left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(top, left);
                }
            }
        }

    }

    public int minPathSumSpaceOptimization(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] dp = new int[c];
        for(int i = 0; i < r; i++) {
            int[] cur = new int[c];
            for(int j = 0; j < c; j++) {
                if(i == 0 && j == 0) {
                    cur[j] = grid[0][0];
                    continue;
                }
                int left = i-1 < 0 ? Integer.MAX_VALUE : grid[i][j] + dp[j];
                int right = j-1 < 0 ? Integer.MAX_VALUE : grid[i][j] + cur[j-1];
                cur[j] = Math.min(left, right);
            }
            dp = cur;
        }
        return dp[c-1];
    }

}
