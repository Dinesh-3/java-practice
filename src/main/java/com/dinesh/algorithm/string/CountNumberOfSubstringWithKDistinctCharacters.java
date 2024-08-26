package com.dinesh.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String input = "aacfssa";
        CountNumberOfSubstringWithKDistinctCharacters distinctCharacters = new CountNumberOfSubstringWithKDistinctCharacters();
        int result = distinctCharacters.getSubstringsCountWithAtMostKDistinct("aacaebceaac", 4);
        System.out.println("result = " + result);
        int kDistinct = countSubstringsWithAtMostKDistinct(input, 3);
        System.out.println("kDistinct = " + kDistinct);
    }

    public int getSubstringsCountWithAtMostKDistinct(String str, int k) {
        return countSubStrings(str, k) - countSubStrings(str, k-1);
    }

    public int countSubStrings(String str, int k) {
        int total = 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char lCh = str.charAt(left);
                map.put(lCh, map.getOrDefault(lCh, 0) - 1);
                if(map.get(lCh) <= 0)
                    map.remove(lCh);
                left++;
            }

            total += right - left + 1;

        }

        return total;
    }

    static int countSubstringsWithAtMostKDistinct(String s, int k) {
        return countSubstringsWithAtMostKDistinctChars(s,k) - countSubstringsWithAtMostKDistinctChars(s,k-1);
    }

    static int countSubstringsWithAtMostKDistinctChars(String s, int k) {
    int left = 0, right = 0, n = s.length(), distinctCount = 0, substringCount = 0;

    int[] charFrequency = new int[26];

    while (right < n) {
        int charIndex = s.charAt(right) - 'a';
        charFrequency[charIndex]++;

        if (charFrequency[charIndex] == 1) {
            distinctCount++;
        }

        while (distinctCount > k) {
            charFrequency[s.charAt(left) - 'a']--;

            if (charFrequency[s.charAt(left) - 'a'] == 0)
                distinctCount--;

            left++;
        }

        substringCount += (right - left + 1);

        right++;
    }

    return substringCount;
}

}
