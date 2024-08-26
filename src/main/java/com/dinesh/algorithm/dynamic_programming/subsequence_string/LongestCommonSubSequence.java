package com.dinesh.algorithm.dynamic_programming.subsequence_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

/**
 *
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence
 *
 * https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
 * https://www.youtube.com/watch?v=NPZn9jBrX8U
 *
 */
public class LongestCommonSubSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        Map<String, Integer> map = new HashMap<>();
        return lcs(text1.length()-1, text2.length()-1, text1, text2, map);
    }

    private int lcs(int index1, int index2, String text1, String text2, Map<String, Integer> map) {
        String key = index1 + "," + index2;
        if(index1 < 0 || index2 < 0)
            return 0;
        if(map.containsKey(key))
            return map.get(key);
        if(text1.charAt(index1) == text2.charAt(index2)) {
            int max = 1 + lcs(index1-1, index2-1, text1, text2, map);
            map.put(key, max);
            return max;
        }
        int max = Math.max(lcs(index1-1, index2, text1, text2, map), lcs(index1, index2-1, text1, text2, map));
        map.put(key, max);
        return max;
    }

    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1+1][l2+1];
        Arrays.deepToString(dp);
        for(int i = 0; i <= l1; i++)
            dp[i][0] = 0;
        for(int i = 0; i <= l2; i++)
            dp[0][i] = 0;

        for(int i1 = 1; i1 <= l1; i1++) {
            for(int i2 = 1; i2 <= l2; i2++) {
                if(text1.charAt(i1-1) == text2.charAt(i2-1))
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }
        return dp[l1][l2];
    }

    private void setAllResults(int[][] dp, String t1, String t2, int i, int j, StringBuilder lcs, SortedSet<String> result) {
        if(i < 0 || j < 0)
            return;
        while(i > 0 && j > 0) {
            if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                lcs.delete(0, t1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                setAllResults(dp, t1, t2, i - 1, j, lcs, result);
                setAllResults(dp, t1, t2, i, j - 1, lcs, result);
                return;
            }
        }

        if(i == 0 || j == 0)
            result.add(lcs.toString());

    }

    public int longestCommonSubsequenceSpaceOptimization(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[] prev = new int[l2+1];

        for(int i1 = 1; i1 <= l1; i1++) {
            int[] current = new int[l2+1];
            for(int i2 = 1; i2 <= l2; i2++) {
                if(text1.charAt(i1-1) == text2.charAt(i2-1))
                    current[i2] = 1 + prev[i2-1];
                else
                    current[i2] = Math.max(prev[i2], current[i2-1]);
            }
            prev = current;
        }
        return prev[l2];
    }

    public int lcsShifting(String text1, String text2) {
        Map<String, Integer> map = new HashMap<>();
        return lcsShiftingIndex(text1.length(), text2.length(), text1, text2, map);
    }

    private int lcsShiftingIndex(int index1, int index2, String text1, String text2, Map<String, Integer> map) {
        String key = index1 + "," + index2;
        if(index1 == 0 || index2 == 0)
            return 0;
        if(map.containsKey(key))
            return map.get(key);
        if(text1.charAt(index1-1) == text2.charAt(index2-1)) {
            int max = 1 + lcsShiftingIndex(index1-1, index2-1, text1, text2, map);
            map.put(key, max);
            return max;
        }
        int max = Math.max(lcsShiftingIndex(index1-1, index2, text1, text2, map), lcsShiftingIndex(index1, index2-1, text1, text2, map));
        map.put(key, max);
        return max;
    }

}
