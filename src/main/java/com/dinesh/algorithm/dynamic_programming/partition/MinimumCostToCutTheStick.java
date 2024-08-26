package com.dinesh.algorithm.dynamic_programming.partition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1547. Minimum Cost to Cut a Stick
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick
 *
 * https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/
 * https://www.youtube.com/watch?v=xwomavsC86c
 *
 */
public class MinimumCostToCutTheStick {
    public int minCostTabulation(int n, int[] cuts) {
        int len = cuts.length;
        int[] range = new int[len+2];
        for(int i = 1; i <= len; i++)
            range[i] = cuts[i-1];
        range[len+1] = n;
        Arrays.sort(range);

        int[][] dp = new int[range.length][range.length];

        for(int i = len; i > 0; i--) {
            for(int j = 1; j <= len; j++) {
                if(i > j)
                    continue;
                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) {
                    int sum = (range[j+1] - range[i-1]) + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(min, sum);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][len];
    }

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] range = new int[len+2];
        for(int i = 1; i <= len; i++)
            range[i] = cuts[i-1];
        range[len+1] = n;
        Arrays.sort(range);

        Map<String, Integer> map = new HashMap<>();
        return minCost(1, len, range, map);
    }

    private int minCost(int i, int j, int[] cuts, Map<String, Integer> map) {
        String key = i + "," + j;
        if(i > j)
            return 0;
        if(map.containsKey(key))
            return map.get(key);
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            int sum = (cuts[j+1] - cuts[i-1]) + minCost(i, k-1, cuts, map) + minCost(k+1, j, cuts, map);
            min = Math.min(min, sum);
        }

        map.put(key, min);
        return min;
    }

}
