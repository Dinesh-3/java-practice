package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private int[] candidates;
    private int target;
    private List<List<Integer>> sums = new ArrayList<>();

    public CombinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
    }

    public static void main(String[] args) {
//        CombinationSum sum = new CombinationSum(new int[]{2, 3, 6, 7}, 7);
//
//        List<List<Integer>> lists = sum.getCombinationSums();
//
//        System.out.println("lists = " + lists);

        int[] nums = {1};
        int target = 1;
        int search = searchInsert(nums, target);

        System.out.println("search = " + search);

    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right - 1) {
            int middle = left + (right - left) / 2;

            if(target == nums[middle])
                return middle;
            else if(target > nums[middle]) {
                left = middle;
            }else {
                right = middle;
            }
        }

        if(nums.length % 2 == 0)
            return nums[left] < target ? left + 1 : left;
        else
            return nums[right] < target ? right + 1 : right;
    }
    public List<List<Integer>> getCombinationSums() {
        List<Integer> current = new ArrayList<>();
        dfs(0, current, 0);
        return sums;
    }

    private void dfs(int i, List<Integer> current, int total) {
        if(total == target)
        {
            List<Integer> copy = List.copyOf(current);
            sums.add(copy);
            return;
        }

        if(i >= candidates.length || total > target)
        {
            return;
        }

        current.add(candidates[i]);
        dfs(i, current, total + candidates[i]);
        current.remove(current.size() - 1);
        dfs(i+1, current, total);
    }
}
