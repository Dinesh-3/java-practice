package com.dinesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        String s = "anasgram", t = "nagaram";
//
//        System.out.println("isAnagram(s, t) = " + isAnagram(s, t));

        int[] array = {12, 5, 34};

        int thirdLargest = findThirdLargest(array);

        if (thirdLargest != -1)
            System.out.println("The third-largest number is: " + thirdLargest);

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

    public static int findThirdLargest(int[] arr) {
        if (arr.length < 3) {
            System.out.println("Array should have at least three elements.");
            return -1;
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax;
    }

}