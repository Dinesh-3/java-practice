package com.dinesh.algorithm.array;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * To Find specifc R, C nCr = n! / r! * (n - r)! => n till r ! / r!; n to (n-r) /  1 to r
 *
 * TO print given row
 *  Formula ans => r - c / c
 *
 * To find next => prevAns * r - c / c
 *
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int rows = 6;

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 1; i < rows; i++)
            ans.add((ans.get(i-1) * (rows - i)) / i);

        System.out.println("ans = " + ans);
    }
}
