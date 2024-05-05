package com.dinesh.algorithm.binary_search;

import java.util.Arrays;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/
 * Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book.
 * There are a ‘m’ number of students, and the task is to allocate all the books to the students.
 *
 * https://leetcode.com/problems/split-array-largest-sum
 *
 */
public class StudentBookAllocation {
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        Integer[] arr = { 12, 34, 67, 90 };
        List<Integer> list = Arrays.asList(arr);
        findPages(list, n, m);

    }

    public static int findPages(List<Integer> arr, int n, int m) {

        if(arr.size() < m)
            return -1;

        int max = 0;
        int sum = 0;

        for(var num: arr) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max;
        int right = sum;

        int ans = -1;

        while(left <= right) {
            int middle = (left+right) / 2;

            if(isPossible(arr, middle, m)) {
                ans = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return ans;
    }

    private static boolean isPossible(List<Integer> arr, int middle, int students) {
        int count = 0;

        int sum = 0;
        for (var page: arr) {
            sum += page;
            if(sum > middle) {
                count++;
                sum = 0;
            }
        }

        if(sum <= middle) {
            count++;
        }

        return count <= students;
    }


}
