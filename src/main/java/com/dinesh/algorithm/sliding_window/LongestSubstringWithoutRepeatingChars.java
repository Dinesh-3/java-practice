package com.dinesh.algorithm.sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 * https://www.youtube.com/watch?v=-zSxTJkcdAo
 *
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
//        lengthOfLongestSubstring("");
        LongestSubstringWithoutRepeatingChars result = new LongestSubstringWithoutRepeatingChars();
//        result.lengthOfLongestSubstringTwo(" ");
    }

    public static int lengthOfLongestSubstring(String s) {

        String input = "abcabcbb";

        int left = 0;
        int right = 0;

        int count = 0;

        Set<Character> chars = new HashSet<>();
        while (right < input.length()) {
            char ch = input.charAt(right);
            if(chars.contains(ch)) {
                chars.remove(input.charAt(left++));
            } else {
                right++;
                chars.add(ch);
            }
            count = Math.max(count, chars.size());
        }

        return 0;
    }

}
