package com.dinesh.algorithm.binary_search;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/
 */
public class FindFirstAndLastPositionOfElement {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElement element = new FindFirstAndLastPositionOfElement();
        int[] nums = {1};
        int target = 1;
        element.searchRange(nums, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int lowerBound = -1;
        while(low <= high) {
            int mid = ( low + high ) / 2;
            if(nums[mid] == target)
                lowerBound = mid;
            if(nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        if(lowerBound == -1)
            return new int[]{ -1, -1 };

        low = lowerBound;
        high = nums.length - 1;
        int upperBound = -1;
        while(low <= high) {
            int mid = ( low + high ) / 2;
            if(nums[mid] == target)
                upperBound = mid;
            if(nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return new int[]{ lowerBound, upperBound };
    }
}
