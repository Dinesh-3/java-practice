package com.dinesh.algorithm.dynamic_programming;

import java.util.*;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths
 */
public class UniquePaths {

    public int uniquePathSpace(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = 1;

        for(int i = 1; i < m; i++) {
            int[] cur = new int[n];
            for(int j = 0; j < n; j++) {
                int top = 0;
                if(i - 1 >= 0)
                    top = dp[j];
                int left = 0;
                if(j - 1 >= 0)
                    left = cur[j - 1];
                cur[j] = top + left;
            }
            dp = cur;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

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

    public int uniquePathsMemoize(int m, int n) {
        Map<String, Integer> map = new HashMap<>();
        return path(m, n, map);
    }

    private int path(int r, int c, Map<String, Integer> map) {
        String key = r + "," + c;
        if(r <= 0 || c <= 0)
            return 0;
        if(r == 1 && c == 1)
            return 1;

        if(map.containsKey(key))
            return map.get(key);

        int res = path(r-1, c, map) + path(r, c-1, map);
        map.put(key, res);
        return res;
    }

}
