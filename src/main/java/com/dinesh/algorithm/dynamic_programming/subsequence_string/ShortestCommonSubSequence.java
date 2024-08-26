package com.dinesh.algorithm.dynamic_programming.subsequence_string;

/**
 *
 * 1092. Shortest Common Supersequence
 * https://leetcode.com/problems/shortest-common-supersequence
 *
 * https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/
 * https://www.youtube.com/watch?v=xElxAuBcvsU
 *
 */

public class ShortestCommonSubSequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i1 = 1; i1 <= l1; i1++) {
            for(int i2 = 1; i2 <= l2; i2++) {
                if(str1.charAt(i1-1) == str2.charAt(i2-1))
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }

        StringBuilder builder = new StringBuilder();

        int i = l1;
        int j = l2;

        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                builder.insert(0, str1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                builder.insert(0, str1.charAt(i-1));
                i--;
            } else {
                builder.insert(0, str2.charAt(j-1));
                j--;
            }
        }

        while(i > 0) {
            builder.insert(0, str1.charAt(i-1));
            i--;
        }
        while(j > 0) {
            builder.insert(0, str2.charAt(j-1));
            j--;
        }

        return builder.toString();

    }
}
