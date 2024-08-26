package com.dinesh.algorithm.binary_search;

/**
 *
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 *
 */
public class MedianTwoSortedArray {

    public static void main(String[] args) {
        MedianTwoSortedArray median = new MedianTwoSortedArray();
        median.findMedianSortedArrays(new int[]{2}, new int[]{});
    }

    public double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
                return findMedianSortedArraysOne(nums2, nums1);
        int length = nums1.length + nums2.length;
        int low = 0;
        int high = nums1.length;

        int split = (length + 1) / 2;

        while(low <= high) {
            int mid = (low + high) / 2;

            int l1 = mid-1 >= 0 && mid-1 < nums1.length ? nums1[mid-1] : Integer.MIN_VALUE;
            int r1 = mid >= 0 && mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;

            int mid2 = split - mid;
            int l2 = mid2-1 >= 0 && mid2-1 < nums2.length ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r2 = mid2 >= 0 && mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if(length % 2 == 1)
                    return Math.max(l1, l2);
                return (double)(Math.max(l1 , l2) + Math.min(r1 , r2)) / 2.0;
            }

            if(l1 > r2)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

}
