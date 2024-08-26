package com.dinesh.algorithm.stack;

import java.util.Stack;

/**
 *
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * https://www.youtube.com/watch?v=ttVu6G7Ayik
 *
 */
public class MaximumRectangles {
    public int maximalRectangle(char[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] mx = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int num = (int) (matrix[i][j] - '0');
                if(i == 0)
                    mx[i][j] = num;
                else
                    mx[i][j] = num == 0 ? 0 : num + mx[i-1][j];
            }
        }

        int max = 0;
        for(int i = 0; i < r; i++)
            max = Math.max(max, largestRectangleArea(mx[i]));

        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftSmaller = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= height)
                stack.pop();
            leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek()+1;
            stack.push(i);
        }

        stack.clear();

        int[] rightSmaller = new int[len];
        for(int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= height)
                stack.pop();
            rightSmaller[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            stack.push(i);
        }

        int max = 0;

        for(int i = 0; i < heights.length; i++)
            max = Math.max(max, (rightSmaller[i] - leftSmaller[i] + 1) * heights[i]);

        return max;

    }
}
