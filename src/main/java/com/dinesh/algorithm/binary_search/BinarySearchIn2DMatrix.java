package com.dinesh.algorithm.binary_search;

public class BinarySearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix2 = {{1,3}};

        int target = 3;
        BinarySearchIn2DMatrix search = new BinarySearchIn2DMatrix();
        boolean result = search.searchMatrix(matrix1, target);
        System.out.println("result = " + result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int left = 0;
        int right = (rowLength) * (columnLength) - 1;

        while( left <= right ) {
            int middle = ( left + right ) / 2;

            int rowIndex = middle / columnLength;
            int columnIndex = middle % columnLength;

            if(matrix[rowIndex][columnIndex] == target)
                return true;

            if(matrix[rowIndex][columnIndex] < target)
                left = middle + 1;
            else
                right = middle - 1;

        }

        return false;

    }

}
