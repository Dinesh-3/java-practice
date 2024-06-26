package com.dinesh.algorithm.array;

public class Rotate2DArrayBy90Degree {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length - 1; i++)
            for(int j = i + 1; j < matrix[0].length; j++)
                swap(matrix, i, j);

        for (int[] row : matrix) reverse(row);

    }

    private static void reverse(int[] arr) {
        int half = arr.length / 2;

        for(int i = 0; i < half; i++)
            swap(arr, i, arr.length - i - 1);
    }

    private static void swap(int[] matrix, int first, int second) {
        int temp = matrix[first];
        matrix[first] = matrix[second];
        matrix[second] = temp;
    }

    private static void swap(int[][] matrix, int first, int second) {
        int temp = matrix[first][second];
        matrix[first][second] = matrix[second][first];
        matrix[second][first] = temp;
    }
}
