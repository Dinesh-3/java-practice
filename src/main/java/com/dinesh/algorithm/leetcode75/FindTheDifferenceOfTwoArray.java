package com.dinesh.algorithm.leetcode75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2215. Find the Difference of Two Arrays
 */
public class FindTheDifferenceOfTwoArray {
    public static void main(String[] args) {
        Integer[] nums1 = {1,2,3};
        Integer[] nums2 = {2,4,6};

        Set<Integer> set1 = Set.of(nums1);
        Set<Integer> set2 = Set.of(nums2);

        List<List<Integer>> diffs = new ArrayList<>();

        List<Integer> diff1 = new ArrayList<>();
        for (var number: set1) {
            if(!set2.contains(number))
                diff1.add(number);
        }

        List<Integer> diff2 = new ArrayList<>();
        for (var number: set2) {
            if(!set1.contains(number))
                diff2.add(number);
        }

        diffs.add(diff1);
        diffs.add(diff2);

    }
}
