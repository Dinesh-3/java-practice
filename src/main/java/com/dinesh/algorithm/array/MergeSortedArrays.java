package com.dinesh.algorithm.array;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * Merge two Sorted Arrays Without Extra Space
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays sortedArrays = new MergeSortedArrays();
        int[] nums1 =  {2,0};
        int[] nums2 = {1};
        sortedArrays.merge(nums1, nums2);
        sortedArrays.mergeTwoSortedArray();

    }

    public void merge(int[] nums1, int[] nums2) {
        int last = nums1.length - 1;

        int first = nums1.length - nums2.length - 1;
        int second = nums2.length - 1;

        while(second >= 0 && first >= 0) {
            if(nums1[first] >= nums2[second]) {
                nums1[last--] = nums1[first--];
            } else {
                nums1[last--] = nums2[second--];
            }
        }

        while(second >= 0 && last >= 0) {
            nums1[last--] = nums2[second--];
        }

    }

    public void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;

        int first = nums1.length - nums2.length - 1;
        int second = nums2.length - 1;

        while(second >= 0) {
            if(first >= 0 && nums1[first] >= nums2[second]) {
                nums1[last--] = nums1[first--];
            } else {
                nums1[last--] = nums2[second--];
            }
        }

    }

    public void mergeTwoSortedArray() {
        int[] arrayOne = { 1, 3, 5, 7 };
        int[] arrayTwo = { 0, 2, 6, 8, 7 };

        int[] minArr = arrayOne.length < arrayTwo.length ? arrayOne : arrayTwo;
        int[] maxArr = arrayOne.length > arrayTwo.length ? arrayOne : arrayTwo;

        int minInTwoIndex = 0;

        for (int i = minArr.length - 1; i >= 0; i--) {
            if(minArr[i] > maxArr[minInTwoIndex]) {
                swap(minArr, maxArr, i, minInTwoIndex++);
            } else
                break;
        }

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        /**
         *     public void mergeTwoSortedArray() {
         *         int[] nums1 = { 1, 3, 5, 7 };
         *         int m = nums1.length;
         *         int[] nums2 = { 0, 2, 6, 8, 7 };
         *         int n = nums2.length;
         *
         *         int n1Right = m - 1;
         *         int n2Left = 0;
         *
         *         while( n1Right >= 0 && n2Left < n && nums1[n1Right] >= nums2[n2Left]) {
         *             int temp = nums1[n1Right];
         *             nums1[n1Right] = nums2[n2Left];
         *             nums2[n2Left] = temp;
         *             n1Right--;
         *             n2Left++;
         *         }
         *
         *         Arrays.sort(nums1);
         *         Arrays.sort(nums2);
         *
         *     }
         */

    }

    private void swap(int[] minArr, int[] maxArr, int arrOne, int arrTwo) {
        int temp = minArr[arrOne];
        minArr[arrOne] = maxArr[arrTwo];
        maxArr[arrTwo] = temp;
    }

    // Cell Sort

    public void mergeCellSortedArray() {
        int[] arrayOne = { 1, 3, 5, 7 };
        int[] arrayTwo = { 0, 2, 6, 8, 7 };

        int gap = (arrayOne.length + arrayTwo.length) / 2;

        while (gap > 1) {



        }

    }


}
