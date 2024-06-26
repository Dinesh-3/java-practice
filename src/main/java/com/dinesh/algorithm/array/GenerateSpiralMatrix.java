package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 */
public class GenerateSpiralMatrix {
    public static void main(String[] args) {
        GenerateSpiralMatrix spiralMatrix = new GenerateSpiralMatrix();
        int[][] matrix = {
            {2,3,4},
            {5,6,7},
            {8,9,10},
            {11,12,13},
            {14,15,16}
        };

        List<Integer> list = spiralMatrix.spiralOrder(matrix);
        System.out.println("list = " + list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {

            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;
            for (int j = top; j <= bottom; j++)
                result.add(matrix[j][right]);
            right--;

            if(top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            if(left <= right) {
                for (int j = bottom; j >= top ; j--)
                    result.add(matrix[j][left]);
                left++;
            }
        }

        return result;
    }

    public List<Integer> printSpiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        List<Integer> result = new ArrayList<>();

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;
            for(int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;
            if(top > bottom || left > right)
                break;
            for(int i = right; i >= left; i--)
                result.add(matrix[bottom][i]);
            bottom--;
            for(int i = bottom; i >= top; i--)
                result.add(matrix[i][left]);
            left++;
        }

        return result;

    }
}
