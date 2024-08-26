package com.dinesh.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462
 * https://www.youtube.com/watch?v=e3bs0uA1NhQ
 *
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        Integer[] numbers = { 33, 17, 24, 23, 7, 7, 37, 17, 37, 24, 10, 15, 16, 22, 1, 2, 19, 34, 36, 18, 21, 13, 18, 22, 1, 9, 30, 28, 26, 16, 12, 14, 1, 21, 17, 19, 14, 38 };
        totalFruits(numbers);
    }
    public static int totalFruits(Integer[] arr) {
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        int left = 0;
        int right = 0;

        while(right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            if(map.size() <= k)
                max = Math.max(max, right - left + 1);
            else {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                if(map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                left++;
            }
            right++;
        }

        return max;
    }

}
