package com.dinesh.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CanSum {
    public static void main(String[] args) {
        int[] array = { 5,1, 4, 3 };
        int target = 16;
//      boolean result = canSum(array, target, 0);
//      boolean result = canSum(array, target);
//      boolean result = canSumMemoize(array, target, new HashMap<>());
        boolean howSum = howSum(array, target);
        System.out.println("howSum = " + howSum);
    }

    private static boolean howSum(int[] array, int target) {
        Stack<Integer> stack = new Stack<>();
        boolean result = howSumMemoize(array, target, new HashMap<>(), stack);
        return result;
    }

    private static boolean canSum(int[] array, int target, int sum) {
        if(sum > target)
            return false;
        if(sum == target)
            return true;

        for (int j : array) {
            if (canSum(array, target, sum + j))
                return true;
        }
        return false;
    }

    private static boolean canSum(int[] array, int target) {
        if(0 == target)
            return true;
        for (int j : array) {
            int diff = target - j;
            if(diff < 0)
                continue;
            if (canSum(array, diff))
                return true;
        }
        return false;
    }

    private static boolean canSumMemoize(int[] array, int target, Map<Integer, Boolean> memo) {
//        if(memo.containsKey(target))
//            return memo.get(target);
        if(0 == target)
            return true;
        if(target < 0)
            return false;
        for (int j : array) {
            int diff = target - j;
            boolean canSumed = canSumMemoize(array, diff, memo);
//            memo.put(diff, canSumed);
            if (canSumed)
                return true;
        }
//        memo.put(target, false);
        return false;
    }

    private static boolean howSumMemoize(int[] array, int target, Map<Integer, Boolean> memo, Stack<Integer> stack) {
        if(memo.containsKey(target))
            return memo.get(target);
        if(0 == target)
            return true;
        if(target < 0)
            return false;
        for (int j : array) {
            int diff = target - j;
            stack.push(j);
            boolean canSumed = howSumMemoize(array, diff, memo, stack);

            memo.put(diff, canSumed);
            if (canSumed)
                return true;
        }
        memo.put(target, false);
        stack.clear();
        return false;
    }

}
