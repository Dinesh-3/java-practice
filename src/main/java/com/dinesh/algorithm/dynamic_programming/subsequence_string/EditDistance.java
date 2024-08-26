package com.dinesh.algorithm.dynamic_programming.subsequence_string;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 *
 * https://takeuforward.org/data-structure/edit-distance-dp-33/
 * https://www.youtube.com/watch?v=fJaKO8FbDdo
 *
 */
public class EditDistance {

    public int minDistanceTabulation(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i = 0; i <= l2; i++)
            dp[0][i] = i;

        for(int i = 0; i <= l1; i++)
            dp[i][0] = i;

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                int insert = 1 + dp[i][j-1];
                int delete = 1 + dp[i-1][j];
                int replace = 1 + dp[i-1][j-1];
                dp[i][j] = Math.min(insert, Math.min(delete, replace));
            }
        }
        return dp[l1][l2];
    }

    public int minDistanceSpaceOptimizationOptimal(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();

        int[] prev = new int[l2+1];

        for(int i = 0; i <= l2; i++)
            prev[i] = i;

        for(int i = 1; i <= l1; i++) {
            int[] curr = new int[l2+1];
            curr[0] = i;
            for(int j = 1; j <= l2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                    continue;
                }
                int insert = 1 + curr[j-1];
                int delete = 1 + prev[j];
                int replace = 1 + prev[j-1];
                curr[j] = Math.min(insert, Math.min(delete, replace));
            }
            prev = curr;
        }
        return prev[l2];
    }

    public int minDistance(String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        return minDistance(word1.length()-1, word2.length()-1, word1, word2, map);
    }

    private int minDistance(int i, int j, String word1, String word2, Map<String, Integer> map) {
        String key = i + "," + j;
        if(i < 0)
            return j + 1;
        if(j < 0)
            return i + 1;

        if(map.containsKey(key))
            return map.get(key);

        if(word1.charAt(i) == word2.charAt(j)) {
            int minOperation = minDistance(i-1, j-1, word1, word2, map);
            map.put(key, minOperation);
            return minOperation;
        }

        int insert = 1 + minDistance(i, j-1, word1, word2, map);
        int delete = 1 + minDistance(i-1, j, word1, word2, map);
        int replace = 1 + minDistance(i-1, j-1, word1, word2, map);

        int minOperation = Math.min(insert, Math.min(delete, replace));
        map.put(key, minOperation);
        return minOperation;
    }

}
