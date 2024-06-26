package com.dinesh.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings
 */
public class IsoMorphicStrings {
    public static void main(String[] args) {
        IsoMorphicStrings isoMorphic= new IsoMorphicStrings();
        isoMorphic.isIsomorphic("bbbaaaba", "aaabbbba");
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map1.containsKey(ch1) && map1.get(ch1) != ch2)
                return false;
            if(map2.containsKey(ch2) && map2.get(ch2) != ch1)
                return false;

            map1.put(ch1, ch2);
            map2.put(ch2, ch1);
        }

        return true;
    }
}
