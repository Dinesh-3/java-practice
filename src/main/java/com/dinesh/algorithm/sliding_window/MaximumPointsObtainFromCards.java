package com.dinesh.algorithm.sliding_window;

/**
 *
 * 1423. Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * https://www.youtube.com/watch?v=pBWCOCS636U
 *
 */
public class MaximumPointsObtainFromCards {

    public static void main(String[] args) {
        int[] cardPoints = { 1,2,3,4,5,6,1 };
        int k = 3;

        MaximumPointsObtainFromCards obtain = new MaximumPointsObtainFromCards();
        obtain.maxScore(cardPoints, k);

    }

    public int maxScore(int[] cardPoints, int k) {
        if(cardPoints.length < k)
            k = cardPoints.length;
        int max = 0;

        for(int i = 0; i < k; i++) {
            max += cardPoints[i];
        }

        if(k == cardPoints.length)
            return max;

        int leftSum = max;
        int rightSum = 0;
        for(int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - i - 1];
            rightSum += cardPoints[cardPoints.length - i - 1];

            max = Math.max(max, leftSum + rightSum);
        }
        return max;
    }
}
