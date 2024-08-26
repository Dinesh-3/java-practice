package com.dinesh.algorithm.dynamic_programming.subsequence_string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/
 *
 * https://takeuforward.org/data-structure/wildcard-matching-dp-34/
 * https://www.youtube.com/watch?v=ZmlQ3vgAOMo
 *
 */
public class WildcardMatching {

    private boolean isAllStars(String p, int i) {
        for(int t = 1; t <= i; t++)
            if(p.charAt(t-1) != '*')
                return false;
        return true;
    }

    public boolean isMatchTabulation(String s, String p) {

        int l1 = p.length();
        int l2 = s.length();

        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;

        for(int i = 1; i <= l1; i++)
            dp[i][0] = isAllStars(p, i);

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(i-1) == '*') {
                    boolean remove = dp[i-1][j];
                    boolean nothing = dp[i][j-1];
                    dp[i][j] = remove || nothing;
                }
            }
        }

        return dp[l1][l2];
    }


    public boolean isMatch(String s, String p) {
        Map<String, Boolean> map = new HashMap<>();
        return isMatch(p.length()-1, s.length()-1, p, s, map);
    }

    private boolean isMatch(int i, int j, String p, String s, Map<String, Boolean> map) {
        String key = i + "," + j;
        if(j < 0 && i < 0)
            return true;
        if(i < 0 && j >= 0)
            return false;
        if(j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++)
                if(p.charAt(k) != '*')
                    return false;
            return true;
        }

        if(map.containsKey(key))
            return map.get(key);

        if(s.charAt(j) == p.charAt(i) || p.charAt(i) == '?') {
            boolean isMathced = isMatch(i-1, j-1, p, s, map);
            map.put(key, isMathced);
            return isMathced;
        }

        if(p.charAt(i) == '*') {
            boolean remove = isMatch(i-1, j, p, s, map);
            boolean nothing = isMatch(i, j-1, p, s, map);
            map.put(key, remove || nothing);
            return remove || nothing;
        }
        map.put(key, false);

        return false;
    }

}
