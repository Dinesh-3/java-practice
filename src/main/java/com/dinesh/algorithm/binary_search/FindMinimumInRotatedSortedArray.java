package com.dinesh.algorithm.binary_search;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 18,13,15,17 };

        int minIndex = approachOne(nums);
        int answer = approachTwo(nums);

        System.out.println("minIndex = " + minIndex);
    }

    private static int approachTwo(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[low] <= nums[mid]) {
                min = Math.min(nums[low], min);
                low = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }

        }

        return min;
    }

    private static int approachOne(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        int minIndex = -1;

        while (leftIndex <= rightIndex) {

            int middleIndex = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(nums[middleIndex] < nums[minIndex])
                minIndex = middleIndex;

            if(nums[leftIndex] <= nums[middleIndex]) {
                if(nums[leftIndex] < nums[minIndex])
                    rightIndex = middleIndex - 1;
                else
                    leftIndex = middleIndex + 1;
            } else {
                if(nums[rightIndex] < nums[minIndex])
                    rightIndex = middleIndex - 1;
                else
                    leftIndex = middleIndex + 1;
            }

        }
        return minIndex;
    }

}
