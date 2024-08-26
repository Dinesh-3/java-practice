package com.dinesh.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 907. Sum of Subarray Minimums
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * https://www.youtube.com/watch?v=v0e8p9JCgRc
 *
 */
public class SumOfSubArrayMinimum {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int[] nse = getNse(arr);
        int[] psee = getPsee(arr);

        long count = 0;

        for(int i = 0; i < arr.length; i++) {
            int leftCount = i - psee[i];
            int rightCount = nse[i] - i;

            count += (long)(leftCount * rightCount)  * arr[i];
            count = count % mod;
        }

        return (int) count;
    }

    private int[] getNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    private int[] getPsee(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
                stack.pop();
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return psee;
    }
}
