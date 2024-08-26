package com.dinesh.algorithm.recursion;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        Set<String> words = new HashSet<>(wordDict);

        return isPossible(s, words, memo);

    }

    private boolean isPossible(String s, Set<String> words, Map<String, Boolean> memo) {
        if(memo.containsKey(s))
            return memo.get(s);

        if(words.contains(s))
            return true;

        for(int i = 1; i < s.length(); i++) {
            if(words.contains(s.substring(0, i)))
                if(isPossible(s.substring(i), words, memo)) {
                    memo.put(s, true);
                    return true;
                }

        }
        memo.put(s, false);
        return false;
    }

}
