package com.dinesh.algorithm.dynamic_programming.longest_increasing_sequence;

import java.util.ArrayList;

/**
 *
 * Print Longest Increasing Subsequence
 * https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence
 *
 * https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/
 * https://www.youtube.com/watch?v=IFfYfonAFGc
 *
 */
public class GetLongestIncreasingSubsequence {
    class Pair {
        int c = 1;
        int prev;
        public Pair (int count, int i) {
            this.c = count;

            this.prev = i;
        }
        public String toString() {
            return "C=" + c + ",prev=" + prev;
        }
    }

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();

        Pair[] dp = new Pair[n];
        for(int i = 0; i < n; i++)
            dp[i] = new Pair(1, i);

        int maxIndex = 0;
        int maxCount = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    int newLength = 1 + dp[j].c;
                    if(dp[i].c < newLength) {
                        dp[i].prev = j;
                        dp[i].c = newLength;
                        if(newLength > maxCount) {
                            maxIndex = i;
                            maxCount = newLength;
                        }
                    }
                }
            }
        }

        int index = maxIndex;

        while(dp[index].prev != index ) {
            result.add(0, arr[index]);
            index = dp[index].prev;
        }

        result.add(0, arr[index]);

        return result;

    }

}
