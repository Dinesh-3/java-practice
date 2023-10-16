package com.dinesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String s = "anasgram", t = "nagaram";

        System.out.println("isAnagram(s, t) = " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (var ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (var ch: t.toCharArray()) {
            if(map.containsKey(ch) && map.get(ch) > 0)
                map.put(ch, map.get(ch) - 1);
            else
                return false;
        }

        return true;

    }
}