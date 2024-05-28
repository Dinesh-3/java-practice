package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountAllSumSequencesWithSumEqualK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int sum = 2;
        Stack<Integer> ds = new Stack<>();
        int count = countSumWithEqualK(arr, sum, 0, arr.length, ds, 0);
        System.out.println("count = " + count);
    }

    private static int countSumWithEqualK(int[] arr, int sum, int index, int length, Stack<Integer> ds, int curSum) {
        if(length <= index ) {
            if(sum == curSum)
                return 1;
            else
                return 0;
        }

        ds.push(arr[index]);
        curSum += arr[index];

        int count = 0;
        count += countSumWithEqualK(arr, sum, index + 1, length, ds, curSum);
        curSum -= ds.pop();

        count += countSumWithEqualK(arr, sum, index + 1, length, ds, curSum);
        return count;
    }
}
