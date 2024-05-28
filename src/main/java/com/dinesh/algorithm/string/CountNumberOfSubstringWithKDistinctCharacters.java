package com.dinesh.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String input = "aacfssa";
        CountNumberOfSubstringWithKDistinctCharacters distinctCharacters = new CountNumberOfSubstringWithKDistinctCharacters();
        int result = distinctCharacters.countSubStrings(input, 3);
        System.out.println("result = " + result);
    }

    public int countSubStrings(String str, int k) {
        int total = 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            char lCh = str.charAt(left);
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                if(map.get(lCh) <= 1) {
                    map.remove(lCh);
                }else {
                    map.put(lCh, map.getOrDefault(lCh, 0) - 1);
                }
                left++;
                if(map.size() == k)
                    total++;
            }

            if(map.size() == k)
                total++;
        }

        return total - 1;
    }


}
