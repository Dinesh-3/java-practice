package com.dinesh.algorithm.dynamic_programming.subsequence_string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 115. Distinct Subsequences
 * https://leetcode.com/problems/distinct-subsequences
 *
 * https://takeuforward.org/data-structure/distinct-subsequences-dp-32/
 * https://www.youtube.com/watch?v=nVG7eTiD2bY
 *
 */

public class DistinctSubsequences {

    public int numDistinctSpaceOptimization(String s, String t) {

        int l1 = s.length();
        int l2 = t.length();

        int[] prev = new int[l2+1];

        for(int i = 0; i <= l1; i++)
            prev[0] = 1;

        for(int i = 1; i <= l1; i++) {
            int[] current = new int[l2+1];
            current[0] = 1;
            for(int j = 1; j <= l2; j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    current[j] = prev[j-1] + prev[j];
                else
                    current[j] = prev[j];
            }
            prev = current;
        }

        return prev[l2];

    }

    public int numDistinctSpaceOptimizationOptimal(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        int[] dp = new int[l2+1];
        dp[0] = 1;

        for(int i = 1; i <= l1; i++)
            for(int j = l2; j > 0; j--)
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[j] = dp[j-1] + dp[j];

        return dp[l2];
    }


    public int numDistinctTabulation(String s, String t) {

        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i = 0; i <= l1; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[l1][l2];

    }

    public int numDistinct(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        return numDistinct(s.length()-1, t.length()-1, s, t, map);
    }

    private int numDistinct(int si, int ti, String s, String t, Map<String, Integer> map) {
        String key = si + "," + ti;
        if(ti < 0)
            return 1;
        if(si < 0)
            return 0;
        if(map.containsKey(key))
            return map.get(key);
        if(s.charAt(si) == t.charAt(ti)) {
            int count = numDistinct(si-1, ti-1, s, t, map) + numDistinct(si-1, ti, s, t, map);
            map.put(key, count);
            return count;
        } else {
            int count = numDistinct(si-1, ti, s, t, map);
            map.put(key, count);
            return count;
        }
    }
}
