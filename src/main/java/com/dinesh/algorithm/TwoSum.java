package com.dinesh.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = { 2, 1, 5, 3 };
        int target = 4;

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            complements.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            System.out.println("diff = " + diff);
            if(complements.containsKey(diff))
                System.out.println("i, j " + i + "," + complements.get(diff));
        }


    }
}
