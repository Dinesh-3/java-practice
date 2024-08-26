package com.dinesh.algorithm.stack;

/**
 *
 * The Celebrity Problem
 * https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
 *
 * https://www.youtube.com/watch?v=cEadsbTeze4
 * https://leetcode.com/problems/find-the-celebrity
 *
 */
public class TheCelebrityProblem {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int[] otherKnows = new int[n];
        int[] knowsMe = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    otherKnows[i] += 1;
                    knowsMe[j] += 1;
                }
            }
        }

        for(int i = 0; i < n; i++)
            if(otherKnows[i] == 0 && knowsMe[i] == (n - 1))
                return i;

        return -1;

    }

    public int celebrityOptimal(int mat[][]) {
        int n = mat.length;

        int low = 0;
        int high = n-1;

        while(low < high) {
            if(mat[low][high] == 1)
                low++;
            else if(mat[high][low] == 1)
                high--;
            else {
                low++;
                high--;
            }
        }

        if(low == high) {
            for(int i = 0; i < n; i++) {
                if(low == i)
                    continue;
                if(mat[low][i] != 0 || mat[i][low] != 1)
                    return -1;
            }

            return low;
        }

        return -1;

    }

}
