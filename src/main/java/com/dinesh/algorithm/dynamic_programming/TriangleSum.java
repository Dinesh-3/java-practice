package com.dinesh.algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 *
 *
 */
public class TriangleSum {
    public static void main(String[] args) {
        List<List<Integer>> triangle =  List.of(
                                        List.of(2),
                                        List.of(3,4),
                                        List.of(6,5,7),
                                        List.of(4,1,8,3)
                                    );
        TriangleSum triangleSum = new TriangleSum();
        triangleSum.minimumTotal(triangle);
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        int r = triangle.size();
        int c = triangle.get(r-1).size();

        int[][] dp = new int[r][c];
        for (var row: dp)
            Arrays.fill(row, -1);

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if(i == 0 && j == 0)
                    dp[0][0] = triangle.get(0).get(0);
                else {
                    int left = Integer.MAX_VALUE;
                    if(j - 1 >= 0)
                        left = triangle.get(i).get(j) + dp[i][j-1];

                    int diag = Integer.MAX_VALUE;
                    if(i - 1 >= 0 && j - 1 >= 0)
                        diag = triangle.get(i).get(j) + dp[i-1][j-1];
                    dp[i][j] = Math.min(left, diag);
                }
            }
        }

        return dp[r-1][c-1];

    }
}
