package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 *
 */
public class SubSetTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        combinationSum(0, nums, result, stack);
        return result;
    }

    private void combinationSum(int index, int[] nums, List<List<Integer>> result, Stack<Integer> stack) {
        result.add(new ArrayList<>(stack));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1])
                continue;
            stack.push(nums[i]);
            combinationSum(i + 1, nums, result, stack);
            stack.pop();
        }
    }
}
