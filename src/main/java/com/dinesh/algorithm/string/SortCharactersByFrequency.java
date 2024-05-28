package com.dinesh.algorithm.string;

import java.util.*;

/**
 *
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {

    }
    public String frequencySort(String s) {
        int[] chars = new int[256];

        Set<Integer> sets = new HashSet<>();

        Map<Character, Integer> map = new HashMap<>();

        for(var ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> current = queue.remove();
            for(int i = 0; i < current.getValue(); i++)
                builder.append(current.getKey());
        }

        return builder.toString();


    }
}
