package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 78. Subsets
 * https://www.youtube.com/watch?v=b7AYbpM5YrE
 * https://leetcode.com/problems/subsets
 *
 */
public class GenerateSubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        getSubsets(nums, 0, result, stack);

        return result;
    }

    private void getSubsets(int[] nums, int index, List<List<Integer>> result, Stack<Integer> stack) {
        if(index == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        stack.push(nums[index]);
        getSubsets(nums, index + 1, result, stack);
        stack.pop();
        getSubsets(nums, index + 1, result, stack);
    }
}
