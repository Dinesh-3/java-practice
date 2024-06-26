package com.dinesh.algorithm.array;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * https://www.youtube.com/watch?v=N0MgLvceX7M
 */
public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        // bruteForce(matrix);
        setZerosOptimal(matrix);

    }

    private static void bruteForce(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    markRowZeros(matrix, i);
                    markColumnZeros(matrix, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    private static void markColumnZeros(int[][] matrix, int j) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][j] = -1;
        }
    }

    private static void markRowZeros(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[i][j] = -1;
        }
    }
    private static void setZerosBetterApproach(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows[i] == -1 || cols[j] == -1)
                    matrix[i][j] = 0;
            }
        }

    }

    private static void setZerosOptimal(int[][] matrix) {
        int col1 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0)
                        col1 = 0;
                    else
                        matrix[0][j] = 0; // mark column
                    matrix[i][0] = 0; // mark row
                }

            }
        }

        // Mark sub matrix zeros
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0)
            for (int i = 1; i < matrix.length; i++)
                matrix[0][i] = 0;

        if(col1 == 0)
            for (int i = 0; i < matrix[0].length; i++)
                matrix[i][0] = 0;
    }

}
