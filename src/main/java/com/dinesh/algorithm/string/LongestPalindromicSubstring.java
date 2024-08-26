package com.dinesh.algorithm.string;

/**
 *
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        String palindrome = "";

        for(int i = 0; i < s.length(); i++) {
            String odd = newPalindrome(i, i, s, palindrome.length());
            String even = newPalindrome(i, i+1, s, palindrome.length());
            if(odd.length() > palindrome.length())
                palindrome = odd;
            if(even.length() > palindrome.length())
                palindrome = even;
        }

        return palindrome;
    }

    private String newPalindrome(int left, int right, String s, int max) {
        String palindrome = "";
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int len = (right - left + 1);
            if(len > max && len > palindrome.length())
                palindrome = s.substring(left, right+1);
            left--;
            right++;
        }

        return palindrome;
    }

}
