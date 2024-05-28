package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CombinationSumTwo {
    public static void main(String[] args) {
        int[] candidates = { 10,1,2,7,6,1,5 };
        int target = 8;
        List<List<Integer>> arr = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        CombinationSumTwo sumTwo = new CombinationSumTwo();
        sumTwo.combinationSum2(candidates, target);
    }

    public List < List < Integer >> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

    private static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
