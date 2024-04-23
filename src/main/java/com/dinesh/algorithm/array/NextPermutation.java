package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**

 * 31. Next Permutation -> https://leetcode.com/problems/next-permutation/description/
 *
 * https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 * https://www.youtube.com/watch?v=JDOXKqF60RQ

 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = { 3,2,1 };


        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                StringBuilder builder = new StringBuilder();
                for (int k = 0; k < arr.length; k++) {
                    if(j == k)
                        builder.append(arr[j]);
                    else
                        builder.append(arr[k]);
                }
                list.add(builder.toString());
                builder.delete(0, builder.length());
            }
        }

    }

}
