package com.dinesh.algorithm.array;


/**
 *
 * Count Inversions
 * https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620
 *
 */
class CountInversions {
    static long inversionCount(long arr[], int n) {
        return mergeSort(arr, 0, arr.length-1);
    }

    private static long mergeSort(long arr[], int low, int high) {
        long count = 0;
        if(low >= high)
            return 0;

        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);

        return count + merge(arr, low, mid, high);
    }

    private static long merge(long[] arr, int low, int mid, int high) {
        int first = low;
        int second = mid+1;

        long count = 0;
        long[] newArr = new long[high-low+1];
        int index = 0;
        while(first <= mid && second <= high) {
            if(arr[first] <= arr[second])
                newArr[index++] = arr[first++];
            else {
                newArr[index++] = arr[second++];
                count += mid - first + 1;
            }
        }

        while(first <= mid)
            newArr[index++] = arr[first++];

        while(second <= high)
            newArr[index++] = arr[second++];

        for(int i = low; i <= high; i++)
            arr[i] = newArr[i-low];

        return count;
    }

}

