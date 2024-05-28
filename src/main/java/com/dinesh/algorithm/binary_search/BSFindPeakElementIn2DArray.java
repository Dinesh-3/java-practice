package com.dinesh.algorithm.binary_search;

import java.util.Arrays;

/**
 * 1901. Find a Peak Element II
 * https://leetcode.com/problems/find-a-peak-element-ii
 */
public class BSFindPeakElementIn2DArray {
    public static void main(String[] args) {
        int[] oneD = {55,77,9,50,49,77,60,68,33,71,2,88,93,15,88,69,97,35,99,83,44,15,
                38,56,21,59,1,93,34,65,98,23,65,14,81,39,82,65,78,26,20,48,98,21,70,100,
                68,1,77,42,63,3,15,47,40,31,8,31,73,11,94,63,9,98,69,99,17,85,61,71,22,34,
                68,78,55,28,70,97,94,89,26,92,40,52,86,84,48,57,67,58,16,32,29,9,44,3,76,71,
                30,76,29,1,10,91,81,8,30,9,5,43,10,66,31,36,86,63,28,70,17,93,74,61,32,61,53,
                25,13,85,56,46,55,53,60,94,7,87,84,83,13,8,52,94,44,14,32,25,69,58,18,55,24,
                36,60,32,10,57,71,13,7,70,2};

        int[][] matrix =  {{55,77,9,50,49,77,60,68,33,71,2,88,93,15,88,69,97,35,99,83,44,15,38},
        {56,21,59,1,93,34,65,98,23,65,14,81,39,82,65,78,26,20,48,98,21,70,100},
        {68,1,77,42,63,3,15,47,40,31,8,31,73,11,94,63,9,98,69,99,17,85,61},
        {71,22,34,68,78,55,28,70,97,94,89,26,92,40,52,86,84,48,57,67,58,16,32},
        {29,9,44,3,76,71,30,76,29,1,10,91,81,8,30,9,5,43,10,66,31,36,86},
        {63,28,70,17,93,74,61,32,61,53,25,13,85,56,46,55,53,60,94,7,87,84,83},
        {13,8,52,94,44,14,32,25,69,58,18,55,24,36,60,32,10,57,71,13,7,70,2}};

        int[][] matrix1 =
                {{11,27,32,31,14},
                {26,4,11,25,1},
                {25,17,30,19,28}};

        BSFindPeakElementIn2DArray element = new BSFindPeakElementIn2DArray();
        int[] ints = element.peekElement(matrix1);

        System.out.println("ints = " + Arrays.toString(ints));
    }

    private int[] peekElement(int[][] arr) {

        int rowLength = arr.length;
        int columnLength = arr[0].length;

        int[] result = new int[2];

        int left = 0;
        int right = (rowLength * columnLength) - 1;

        while (left <= right) {
            int middle = ( left + right ) / 2;

            int rowIndex = middle / columnLength;
            int columnIndex = middle % columnLength;

            int target = getElement(arr, middle);

            int maxIndex = getMaxElement(arr, middle);

            int leftVal = getElement(arr, rowIndex, maxIndex - 1);
            int rightVal = getElement(arr, rowIndex, maxIndex + 1);

            if(leftVal <= target && target >= rightVal)
                return new int[]{rowIndex, columnIndex};
            if(leftVal < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return result;
    }

    private int[] peekPrevElement(int[][] arr) {

        int rowLength = arr.length;
        int columnLength = arr[0].length;

        int[] result = new int[2];

        int left = 0;
        int right = (rowLength * columnLength) - 1;

        while (left <= right) {
            int middle = ( left + right ) / 2;

            int rowIndex = middle / columnLength;
            int columnIndex = middle % columnLength;

            int target = getElement(arr, middle);

            int leftVal = getElement(arr, middle - 1);
            int rightVal = getElement(arr, middle + 1);

            int topVal = getElement(arr, rowIndex - 1, columnIndex);
            int bottomVal = getElement(arr, rowIndex + 1, columnIndex);

            if(leftVal <= target && target >= rightVal
                    && topVal <= target && target >= bottomVal
            )
                return new int[]{rowIndex, columnIndex};
            if(leftVal < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return result;
    }

    private int getElement(int[][] arr, int rowIndex, int columnIndex) {
        int rowLength = arr.length;
        int columnLength = arr[0].length;

        if(rowIndex >= rowLength || rowIndex < 0)
            return -1;
        if(columnIndex >= columnLength || columnIndex < 0)
            return -1;
        return arr[rowIndex][columnIndex];
    }

    private int getElement(int[][] arr, int middle) {
        int rowLength = arr.length;
        int columnLength = arr[0].length;

        int rowIndex = middle / columnLength;
        int columnIndex = middle % columnLength;

        if(rowIndex >= rowLength || rowIndex < 0)
            return -1;
        if(columnIndex >= columnLength || columnIndex < 0)
            return -1;
        return arr[rowIndex][columnIndex];
    }
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int startCol = 0, endCol = mat[0].length-1;

            while(startCol <= endCol){
                int maxRow = 0, midCol = startCol + (endCol-startCol)/2;

                for(int row=0; row<mat.length; row++){
                    maxRow = mat[row][midCol] >= mat[maxRow][midCol]? row : maxRow;
                }

                boolean leftIsBig    =   midCol-1 >= startCol  &&  mat[maxRow][midCol-1] > mat[maxRow][midCol];
                boolean rightIsBig   =   midCol+1 <= endCol    &&  mat[maxRow][midCol+1] > mat[maxRow][midCol];

                if(!leftIsBig && !rightIsBig)   // we have found the peak element
                    return new int[]{maxRow, midCol};

                else if(rightIsBig)  // if rightIsBig, then there is an element in 'right' that is bigger than all the elements in the 'midCol',
                    startCol = midCol+1; //so 'midCol' cannot have a 'peakPlane'

                else // leftIsBig
                    endCol = midCol-1;
            }
            return null;
        }
    }
    private int getMaxElement(int[][] arr, int col) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i][col]) {
                max = arr[i][col];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}
