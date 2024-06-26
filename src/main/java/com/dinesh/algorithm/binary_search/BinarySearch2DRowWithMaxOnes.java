package com.dinesh.algorithm.binary_search;

public class BinarySearch2DRowWithMaxOnes {
    int rowWithMax1s(int[][] arr, int n, int m) {
        int maxCount = 0;
        int maxRow = -1;

        for(int i = 0; i < arr.length; i++) {
            int count = lowerBound(arr[i]);
            if(count > maxCount) {
                maxCount = count;
                maxRow = i;
            }

        }

        return maxRow;
    }

    private int lowerBound(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return arr.length - left;
    }

}
