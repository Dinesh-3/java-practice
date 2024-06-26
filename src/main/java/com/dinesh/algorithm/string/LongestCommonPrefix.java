package com.dinesh.algorithm.string;

/**
 *
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for(int j = 0; j < first.length(); j++) {
            char ch = first.charAt(j);
            for(int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if(str.length() <= j)
                    return first.substring(0, j);
                if(str.charAt(j) != ch)
                    return j > 0 ? first.substring(0, j) : "";
            }
        }

        return first;
    }
}
