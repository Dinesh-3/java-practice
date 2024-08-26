package com.dinesh.algorithm.binary_search;

/**
 *
 * Median in a row-wise sorted Matrix
 * https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527
 *
 * https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
 * https://www.youtube.com/watch?v=Q9wXgdxJq48
 *
 */
public class MedianInRowWiseSortedMatrix {
    public static void main(String[] args) {
        MedianInRowWiseSortedMatrix median = new MedianInRowWiseSortedMatrix();
        int R = 3, C = 3;
        int[][] M = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        median.median(M, R, C);
    }
    int median(int[][] matrix, int R, int C) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int[] row: matrix) {
            low = Math.min(row[0], low);
            high = Math.max(row[C-1], high);
        }

        while(low <= high) {
            int mid = (low + high) / 2;

            int count = getCount(matrix, mid);

            if(count <= ((R*C) / 2))
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;

    }

    private int getCount(int[][] matrix, int len) {

        int count = 0;

        for(int[] row: matrix)
            count += upperBound(row, len);

        return count;
    }

    private int upperBound(int[] arr, int len) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] <= len)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

}
