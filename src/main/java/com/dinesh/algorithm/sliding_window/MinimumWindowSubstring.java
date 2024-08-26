package com.dinesh.algorithm.sliding_window;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring window = new MinimumWindowSubstring();
        window.minWindow("a", "b");
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";

        int[] chars = new int[256];

        for(char ch: t.toCharArray())
            chars[ch] += 1;

        int left = 0;
        int right = 0;

        int count = 0;
        int minLength = s.length();
        int startIndex = 0;

        while(right < s.length()) {
            char ch = s.charAt(right);
            if(chars[ch] >= 1)
                count++;

            chars[ch]--;

            while(count == t.length()) {
                if((right-left + 1)  < minLength) {
                    minLength = (right-left + 1);
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                chars[leftChar]++;
                if(chars[leftChar] >= 1)
                    count--;
                left++;
            }

            right++;
        }

        return s.substring(startIndex, startIndex+minLength);
    }
}
