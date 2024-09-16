package com.dinesh.algorithm.dynamic_programming;

import java.util.*;

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
    }

    private int max = (int)(1e9 + 7);
    public int minimumTotalMemoization(List<List<Integer>> triangle) {
        Map<String, Integer> map = new HashMap<>();
        return traverse(0, 0, triangle, map);
    }

    private int traverse(int r, int c, List<List<Integer>> triangle, Map<String, Integer> map) {
        String key = r + "," + c;
        int row = triangle.size();
        if(r == row)
            return 0;
        if(c >= triangle.get(r).size())
            return 0;
        if(map.containsKey(key))
            return map.get(key);

        int left = triangle.get(r).get(c) + traverse(r+1, c, triangle, map);
        int right = triangle.get(r).get(c) + traverse(r+1, c+1, triangle, map);
        map.put(key, Math.min(left, right));
        return map.get(key);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();

        int[][] dp = new int[r][r];

        for(int i = 0; i < r; i++)
            dp[r-1][i] = triangle.get(r-1).get(i);

        for(int i = r-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int left = triangle.get(i).get(j) + dp[i+1][j];
                int right = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(left, right);
            }
        }

        return dp[0][0];
    }


    public int minimumTotalSpaceOptimization(List<List<Integer>> triangle) {
        int r = triangle.size();

        int[] dp = new int[r];

        for(int i = 0; i < r; i++)
            dp[i] = triangle.get(r-1).get(i);

        for(int i = r-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int left = triangle.get(i).get(j) + dp[j];
                int right = triangle.get(i).get(j) + dp[j+1];
                dp[j] = Math.min(left, right);
            }
        }

        return dp[0];
    }


}
