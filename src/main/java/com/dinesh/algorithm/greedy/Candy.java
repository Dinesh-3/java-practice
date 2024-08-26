package com.dinesh.algorithm.greedy;

/**
 *
 * 135. Candy
 * https://leetcode.com/problems/candy
 *
 * https://www.youtube.com/watch?v=IIqVFvKE6RY
 *
 */
public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;

        int sum = 1;
        int index = 1;

        while(index < len) {
            if(ratings[index] == ratings[index-1]) {
                sum++;
                index++;
                continue;
            }

            int peak = 1;
            while(index < len && ratings[index] > ratings[index-1]) {
                peak++;
                sum += peak;
                index++;
            }

            int down = 1;
            while(index < len && ratings[index] < ratings[index-1]) {
                sum += down;
                down++;
                index++;
            }

            if(down > peak)
                sum += (down - peak);

        }

        return sum;
    }
}
