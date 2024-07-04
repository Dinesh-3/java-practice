package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, target, result, stack);
        return result;
    }

    private void combinationSum(int index, int[] candidates, int target, List<List<Integer>> result, Stack<Integer> stack) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            stack.push(candidates[i]);
            combinationSum(i + 1, candidates, target - candidates[i], result, stack);
            stack.pop();
        }
    }
}
