package com.dinesh.algorithm.binary_search;

/**
 *
 * K-th element of two Arrays
 *
 * https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317
 *
 * https://www.youtube.com/watch?v=D1oDwWCq50g
 * https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/
 *
 */
public class FindKthElementOnTwoSortedArray {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        if(n > m)
            return kthElement(arr2, arr1, m, n, k);

        int length = arr1.length + arr2.length;
        int low = Math.max(0, k-m);
        int high = Math.min(k, n);

        int split = k;

        while(low <= high) {
            int mid = (low + high) / 2;

            int l1 = mid-1 >= 0 && mid-1 < arr1.length ? arr1[mid-1] : Integer.MIN_VALUE;
            int r1 = mid >= 0 && mid < arr1.length ? arr1[mid] : Integer.MAX_VALUE;

            int mid2 = split - mid;
            int l2 = mid2-1 >= 0 && mid2-1 < arr2.length ? arr2[mid2-1] : Integer.MIN_VALUE;
            int r2 = mid2 >= 0 && mid2 < arr2.length ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1)
                return Math.max(l1,l2);

            if(l1 > r2)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;

    }

}
