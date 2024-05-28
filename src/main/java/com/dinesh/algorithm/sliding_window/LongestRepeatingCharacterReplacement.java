package com.dinesh.algorithm.sliding_window;

/**
 *
 * https://www.youtube.com/watch?v=_eNhaDCr6P0
 *
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement
 *
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        char[] chars = new char[26];

        int left = 0;
        int right = 0;
        int max = 0;
        char maxChar = 'A';

        int count = 0;

        while (right < s.length()) {
            char ch = s.charAt(right++);
            chars[ch-'A']++;
            if(chars[ch-'A'] > max) {
                max = chars[ch-'A'];
                maxChar = ch;
            }
            int diff = (right - left) - max;
            if(diff <= k) {
                count = Math.max(count, right - left);
            }else {
                char leftChar = s.charAt(left++);
                chars[leftChar- 'A']--;
                if(leftChar == maxChar)
                    max--;
            }
        }

        System.out.println("count = " + count);

    }

}
