package com.dinesh.algorithm.dynamic_programming;

import java.util.*;

/**
 * What is Dynamic Programming ?

 * 1. Sum the numbers series using recursion => 4 -> 4 + 3 + 2 + 1 = 10
 * 2. Fibonacci Sequence using Recursion with Memoization
 *
 */
public class Main {

    public static void main(String[] args) {
        int result = fib(50);
        List<Integer> numbers = Arrays.asList(7,14);
        System.out.println(canSum(300, numbers));
    }

    public static int fib(int number) {
        return fib(number, new HashMap<>());
    }
    public static int fib(int number, Map<Integer, Integer> map) {
        if(map.containsKey(number)) return map.get(number);
        if(number <= 2) return 1;
        int result = fib(number - 1, map) + fib(number - 2, map);
        map.put(number, result);
        return result;
    }


    public static int findAllPossiblePaths(int[][] array, int left, int right) {
        return 1;
    }

    public static boolean canSum(int target, List<Integer> numbers) {
        return canSum(target, numbers, new HashMap<>());
    }
    public static boolean canSum(int target, List<Integer> numbers, Map<Integer, Boolean> mem) {
        if(mem.containsKey(target)) return mem.get(target);

        if(target < 0) {
            mem.put(target, false);
            return false;
        };
        if(target == 0) {
            mem.put(target, true);
            return true;
        }

        for (int number: numbers) {
            boolean result = canSum(target - number, numbers, mem);
            if(result) return true;
        }

        mem.put(target, false);
        return false;
    }

}
