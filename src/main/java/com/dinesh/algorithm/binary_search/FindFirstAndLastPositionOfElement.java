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

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex <= rightIndex) {

            int mid = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(nums[mid] == target) {
                int first = mid;

                for(int i = mid; i >= 0; i--) {
                    if(nums[i] != target)
                        break;
                    first = i;
                }

                int last = mid;
                for(int i = mid; i < nums.length; i++) {
                    if(nums[i] != target)
                        break;
                    last = i;
                }

                return new int[]{ first, last };
            }

            if(nums[mid] < target)
                leftIndex = mid + 1;
            else
                rightIndex = mid - 1;

        }

        return new int[]{ -1, -1 };

    }
}
