package com.dinesh.algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/
 * https://www.youtube.com/watch?v=hnswaLJvr6g
 *
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray
 *
 */
public class MaximumProductSubArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> subSet = new ArrayList<>();
        subSet.sort(Comparator.naturalOrder());
        String result = subSet.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        ;
    }
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;

        double prefix = 1;
        double suffix = 1;
        for(int i = 0; i < nums.length; i++) {
            if(prefix == 0)
                prefix = 1;
            if(suffix == 0)
                suffix = 1;
            prefix *= nums[i];
            suffix *= nums[ nums.length - i - 1];

            max = (int) Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
}
