package com.dinesh.algorithm.dynamic_programming.subsequence_string;

/**
 *
 * 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        String t1 = word1;
        String t2 = word2;

        int l1 = t1.length();
        int l2 = t2.length();

        int[] prev = new int[l2+1];

        for(int i1 = 1; i1 <= l1; i1++) {
            int[] curr = new int[l2+1];
            for(int i2 = 1; i2 <= l2; i2++) {
                if(t1.charAt(i1-1) == t2.charAt(i2-1))
                    curr[i2] = 1 + prev[i2-1];
                else {
                    curr[i2] = Math.max(prev[i2], curr[i2-1]);
                }
            }
            prev = curr;
        }

        return t1.length() + t2.length() - (2 * prev[l2]);

    }
}
