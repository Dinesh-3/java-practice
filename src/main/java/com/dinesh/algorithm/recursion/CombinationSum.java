package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        combinationSum(0, sum, candidates, target, result, stack);
        return result;
    }

    private void combinationSum(int index, int sum, int[] candidates, int target, List<List<Integer>> result, Stack<Integer> stack) {
        if(index == candidates.length) {
            if(target == sum)
                result.add(new ArrayList<>(stack));
            return;
        }
        if(index >= candidates.length || sum > target)
            return;
        stack.push(candidates[index]);
        combinationSum(index, sum + candidates[index], candidates, target, result, stack);
        stack.pop();
        combinationSum(index + 1, sum, candidates, target, result, stack);
    }
}
