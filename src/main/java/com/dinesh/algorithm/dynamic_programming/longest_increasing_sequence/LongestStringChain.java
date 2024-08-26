package com.dinesh.algorithm.dynamic_programming.longest_increasing_sequence;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain
 *
 *
 * https://takeuforward.org/data-structure/longest-string-chain-dp-45/
 * https://www.youtube.com/watch?v=YY8iBaYcc4g
 *
 *
 */
public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain chain = new LongestStringChain();
        chain.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"});
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int max = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                boolean isValid = isValidChain(words[i], words[j]);
                if(isValid && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }

    private boolean isValidChain(String first, String second) {
        if(first.length() != second.length()+1)
            return false;
        int left = 0;
        int right = 0;

        while(left < first.length()) {
            if(right < second.length() && first.charAt(left) == second.charAt(right)) {
                left++;
                right++;
            } else {
                left++;
            }
        }

        return first.length() == left && second.length() == right;
    }

}
