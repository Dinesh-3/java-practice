package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning
 *
 * https://www.youtube.com/watch?v=WBgsABoClE0
 * https://takeuforward.org/data-structure/palindrome-partitioning/
 *
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        generateSubstrings(0, s, stack, result);

        return result;
    }

    private void generateSubstrings(int index, String s, Stack<String> stack, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(index, i, s)) {
                stack.push(s.substring(index, i+1));
                generateSubstrings(i+1, s, stack, result);
                stack.pop();
            }
        }

    }

    private boolean isPalindrome(int start, int end, String str) {
        while(start < end) {
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }

}
