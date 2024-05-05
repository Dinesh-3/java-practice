package com.dinesh.algorithm.binary_search;

/**
 * https://www.youtube.com/watch?v=9ZbB397jU4k
 * 240. Search a 2D Matrix II
 * https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/
 * Search in a row and column-wise sorted matrix
 */
public class BSSearchIn2DColumnSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        BSSearchIn2DColumnSortedMatrix search = new BSSearchIn2DColumnSortedMatrix();
        boolean result = search.searchMatrix(matrix, target);
        System.out.println("result = " + result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = 0;
        int columnIndex = matrix[0].length - 1;

        while(columnIndex >= 0 && rowIndex < matrix.length) {
            if(matrix[rowIndex][columnIndex] == target)
                return true;

            if(matrix[rowIndex][columnIndex] > target)
                columnIndex = columnIndex - 1;
            else
                rowIndex = rowIndex + 1;
        }
        return false;
    }
}
