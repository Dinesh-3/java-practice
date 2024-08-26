package com.dinesh.algorithm.dynamic_programming;

/**
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum
 *
 * Minimum/Maximum Falling Path Sum (DP-12)
 * https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/
 * https://www.youtube.com/watch?v=N_aJ5qQbYA0
 *
 */
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        MinimumFallingPathSum pathSum = new MinimumFallingPathSum();
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        pathSum.minFallingPathSum(matrix);
    }

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Integer[][] dp = new Integer[row][col];


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++) {
            int cMin = minFallingPathSum(row - 1, i, matrix, dp);
            min = Math.min(min, cMin);
        }

        return min;

    }

    public int minFallingPathSum(int row, int col, int[][] matrix, Integer[][] dp) {
        int rowL = matrix.length;
        int colL = matrix[0].length;
        if(row < 0 || col < 0 || col >= colL)
            return (int) Math.pow(10,9);
        if(row == 0)
            return matrix[row][col];

        if(dp[row][col] != null)
            return dp[row][col];

        int topLeft = matrix[row][col] + minFallingPathSum(row - 1, col - 1, matrix, dp);
        int top = matrix[row][col] + minFallingPathSum(row - 1, col, matrix, dp);
        int topRight = matrix[row][col] + minFallingPathSum(row - 1, col + 1, matrix, dp);

        dp[row][col] = Math.min(topLeft, Math.min(top, topRight));
        return dp[row][col];
    }

    public int minFallingPathSumTabulation(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Integer[][] dp = new Integer[r][c];

        for(int i = 0; i < c; i++)
            dp[0][i] = matrix[0][i];

        for(int i = 1; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int left = j-1 >= 0 ? matrix[i][j] + dp[i-1][j-1] : Integer.MAX_VALUE;
                int top = matrix[i][j] + dp[i-1][j];
                int right = j+1 < c ? matrix[i][j] + dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(Math.min(left, top), right);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < c; i++)
            min = Math.min(min, dp[r-1][i]);

        return min;
    }

    public int minFallingPathSumSpaceOptimization(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Integer[] prev = new Integer[c];

        for(int i = 0; i < c; i++)
            prev[i] = matrix[0][i];

        for(int i = 1; i < r; i++) {
            Integer[] current = new Integer[c];
            for(int j = 0; j < c; j++) {
                int left = j-1 >= 0 ? matrix[i][j] + prev[j-1] : Integer.MAX_VALUE;
                int top = matrix[i][j] + prev[j];
                int right = j+1 < c ? matrix[i][j] + prev[j+1] : Integer.MAX_VALUE;
                current[j] = Math.min(Math.min(left, top), right);
            }
            prev = current;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < c; i++)
            min = Math.min(min, prev[i]);

        return min;
    }


}
