package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
 * https://www.youtube.com/watch?v=rYkfBRtMJr8
 * https://www.geeksforgeeks.org/problems/subset-sums2234
 *
 */
public class SubSetSums {
    public static void main(String[] args) {
        SubSetSums sums = new SubSetSums();
        ArrayList<Integer> arr = new ArrayList<>(List.of(2, 3));
        sums.subsetSums(arr, arr.size());
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        combinationSum(0, 0, arr, result);
        return result;
    }

    private void combinationSum(int index, int sum, ArrayList<Integer> arr, ArrayList<Integer> result) {
        if(index >= arr.size()) {
            result.add(sum);
            return;
        }
        combinationSum(index + 1, sum + arr.get(index), arr, result);
        combinationSum(index + 1, sum, arr, result);

    }
}
