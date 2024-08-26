package com.dinesh.algorithm.dynamic_programming.subsequence_string;

/**
 *
 * Longest Common Substring
 * https://www.geeksforgeeks.org/problems/longest-common-substring1452
 *
 * https://www.youtube.com/watch?v=_wP9mWNPL5w
 *
 *
 */
public class LongestCommonSubString {
    public int longestCommonSubstr(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];

        int max = 0;
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return max;
    }
}
