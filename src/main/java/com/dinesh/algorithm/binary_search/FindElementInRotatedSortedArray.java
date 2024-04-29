package com.dinesh.algorithm.binary_search;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class FindElementInRotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2,3}; // unique elements
        int target = 0;

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while(leftIndex <= rightIndex) {

            int mid = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(arr[mid] == target) {
                System.out.println("mid = " + mid);
                break;
            }

            if(arr[leftIndex] <= arr[mid]) {
                if(arr[leftIndex] <= target && arr[mid] >= target)
                    rightIndex = mid - 1;
                else
                    leftIndex = mid + 1;
            } else {
                if(arr[mid] <= target && arr[rightIndex] >= target)
                    leftIndex = mid + 1;
                else
                    rightIndex = mid - 1;
            }
        }

    }

}
