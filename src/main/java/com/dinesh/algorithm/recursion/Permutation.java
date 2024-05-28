package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity n!
 * Space Complexity 0(n) Recursive calls
 */
public class Permutation {
    public static void main(String[] args) {
        String arr = "123";
        List<String> permutations = new ArrayList<>();
        permutation("",arr, permutations);
        System.out.println("permutations = " + permutations);
    }

    private static void permutation(String prefix, String str, List<String> permutations) {
        int n = str.length();
        if (n == 0) permutations.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), permutations);
        }
    }

}
