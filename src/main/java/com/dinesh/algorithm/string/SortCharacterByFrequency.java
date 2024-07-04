package com.dinesh.algorithm.string;

import java.util.*;

public class SortCharacterByFrequency {
    public static void main(String[] args) {
        SortCharacterByFrequency frequency = new SortCharacterByFrequency();
        String result = frequency.frequencySort("Aabb");
        System.out.println("result = " + result);
    }
    public String frequencySort(String s) {
        SortedMap<Character, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for(char ch: s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        StringBuilder builder = new StringBuilder();

        for(var entry: map.entrySet())
            builder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));

        return builder.toString();
    }
}
