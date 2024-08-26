package com.dinesh.algorithm.dynamic_programming.longest_increasing_sequence;

import java.util.*;

/**
 *
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 * https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/
 * https://www.youtube.com/watch?v=gDuZwBW9VvM
 *
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubsetTabulation(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] path = new int[n];
        for(int i = 0; i < n; i++)
            path[i] = i;

        int maxCount = 1;
        int maxIndex = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    int newCount = dp[j]+1;
                    if(newCount > dp[i]) {
                        dp[i] = newCount;
                        path[i] = j;
                        if(maxCount < newCount) {
                            maxCount = newCount;
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while(path[maxIndex] != maxIndex) {
            res.add(nums[maxIndex]);
            maxIndex = path[maxIndex];
        }

        res.add(nums[maxIndex]);

        return res;

    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Queue<List<Integer>> result = new PriorityQueue<>((a, b) -> b.size() - a.size());
        Stack<Integer> stack = new Stack<>();
        lds(0, nums, stack, result);
        return result.remove();
    }

    private void lds(int index, int[] nums, Stack<Integer> stack, Queue<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        if(stack.isEmpty()) {
            stack.add(nums[index]);
            lds(index+1, nums, stack, result);
        } else {
            if(nums[index] % stack.peek() == 0) {
                stack.add(nums[index]);
                lds(index+1, nums, stack, result);
            } else
                lds(index+1, nums, new Stack<>(), result);
        }
    }
}
