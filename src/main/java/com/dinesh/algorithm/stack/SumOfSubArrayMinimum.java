package com.dinesh.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfSubArrayMinimum {
    public static void main(String[] args) {
        int[] arr = { 3,1,2,4 };

        List<List<Integer>> combinations = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        getCombinations(arr, 0, combinations, stack);
        System.out.println("combinations = " + combinations);
    }

    private static void getCombinations(int[] arr, int index, List<List<Integer>> combinations, Stack<Integer> stack) {
        if(index == arr.length)
        {
            combinations.add(new ArrayList<>(stack));
            return;
        }
        stack.push(arr[index]);
        getCombinations(arr, index+1, combinations, stack);
        stack.pop();
        getCombinations(arr, index + 1, combinations, stack);
    }

}
