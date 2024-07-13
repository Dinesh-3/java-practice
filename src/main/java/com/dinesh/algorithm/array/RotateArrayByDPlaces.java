package com.dinesh.algorithm.array;

import java.util.ArrayList;

/**
 *
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array
 *
 * https://takeuforward.org/data-structure/left-rotate-the-array-by-one/
 * https://www.youtube.com/watch?v=wvcQg43_V8U
 *
 *
 * Intuition
 * 1. Consider split point as d from end.
 * 2. Reverse first from mid and mid from end
 * 3. Reverse complete Array
 */
public class RotateArrayByDPlaces {
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();
    }

    public void rotate(int[] nums, int k) {
        if(nums.length == k)
            return;
        k = k % nums.length;

        int midPoint = nums.length - k;

        reverse(nums, 0,  midPoint - 1);
        reverse(nums, midPoint, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while(left < right)
            swap(arr, left++, right--);
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


}
