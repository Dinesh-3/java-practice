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

    public int characterReplacement(String s, int k) {
        int[] chars = new int[256];
        int maxCharL = 0;
        int maxChar = 'A';

        int left = 0;
        int right = 0;

        int maxLength = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);
            chars[ch]++;
            if(chars[ch] > maxCharL) {
                maxChar = chars[ch];
                maxCharL = chars[ch];
            }
            if((right - left - maxCharL + 1) <= k)
            {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                char charLeft = s.charAt(left);
                chars[charLeft]--;

                if(charLeft == maxChar)
                    maxCharL--;
                left++;
            }
            right++;
        }

        return maxLength;

    }

}
