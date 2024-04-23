package com.dinesh.algorithm.leetcode75;

import java.util.*;
/**
 * 1207. Unique Number of Occurrences
 *
 */
public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
    }

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for(var number : arr)
            map.put(number, map.getOrDefault(number, 0) + 1);

        Set<Integer> uniques = new HashSet<>();

        for(var count: map.values()) {
            if(uniques.contains(count))
                return false;
            else
                uniques.add(count);
        }

        return true;
    }
}
