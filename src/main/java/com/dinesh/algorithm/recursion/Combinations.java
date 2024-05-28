package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> combinations = new ArrayList<>();
        getAllCombinations(arr, 0, new Stack<>(), combinations);
        System.out.println("combinations = " + combinations);
    }

    private static void getAllCombinations(int[] array, int index, Stack<Integer> stack, List<List<Integer>> combinations) {
        if(array.length == index)
        {
            combinations.add(new ArrayList<>(stack));
            return;
        }

        stack.push(array[index]);
        getAllCombinations(array, index + 1, stack, combinations);
        stack.pop();
        getAllCombinations(array, index + 1, stack, combinations);

    }
}
