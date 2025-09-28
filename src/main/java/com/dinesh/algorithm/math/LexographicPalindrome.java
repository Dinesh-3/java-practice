package com.dinesh.algorithm.math;

import java.util.*;

public class LexographicPalindrome {
    public static String makeSmallestPalindrome(String s) {
        if (s.length() <= 1) {
            return s; // Empty string or single-character string is already a palindrome
        }

        int n = s.length();
        char[] chars = s.toCharArray();

        int left = 0, right = n - 1;
        int changes = 0;

        while (left < right) {
            if (chars[left] != chars[right]) {
                changes++;
                // Replace the character at the left with the character at the right
                chars[left] = chars[right];
            }
            left++;
            right--;
        }

        // If the number of changes is odd, we need to replace one more character
        if (changes % 2 != 0) {
            // Find the first character that is different from its corresponding character on the other side
            for (int i = 0; i < n / 2; i++) {
                if (chars[i] != chars[n - 1 - i]) {
                    // Replace the character with the lexicographically smaller one
                    chars[i] = (chars[i] < chars[n - 1 - i]) ? chars[i] : chars[n - 1 - i];
                    break;
                }
            }
        }

        return new String(chars);

    }

    public static void main(String[] args) {
        // Test cases
        String s = "fhaigh";
        System.out.println("Smallest lexicographical palindrome: " + makeSmallestPalindrome(s));

        // Another example
        String s2 = "racecar";
        System.out.println("Smallest lexicographical palindrome: " + makeSmallestPalindrome(s2));
    }
}

