package com.dinesh.algorithm.dynamic_programming.subsequence_string;

/**
 *
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 *
 * https://www.youtube.com/watch?v=yMnH0jrir0Q
 *
 */
public class MinimumInsertionToMakeStringPalindrome {
    public int minInsertions(String s) {
        String t1 = s;
        StringBuilder sb = new StringBuilder(s);
        String t2 = sb.reverse().toString();

        int n = t1.length();
        int[] prev = new int[n+1];

        for(int i1 = 1; i1 <= n; i1++) {
            int[] curr = new int[n+1];
            for(int i2 = 1; i2 <= n; i2++) {
                if(t1.charAt(i1-1) == t2.charAt(i2-1))
                    curr[i2] = 1 + prev[i2-1];
                else {
                    curr[i2] = Math.max(prev[i2], curr[i2-1]);
                }
            }
            prev = curr;
        }

        return s.length() - prev[n];

    }
}
