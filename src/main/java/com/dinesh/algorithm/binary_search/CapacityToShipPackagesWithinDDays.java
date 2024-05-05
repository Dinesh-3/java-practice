package com.dinesh.algorithm.binary_search;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = { 3,3,3,3,3,3 };
        int days = 2;

        CapacityToShipPackagesWithinDDays capacity = new CapacityToShipPackagesWithinDDays();
        capacity.shipWithinDays(weights, days);

    }
    public int shipWithinDays(int[] weights, int days) {

        int min = weights[0];
        int max = 0;

        for (var weight: weights) {
            min = Math.min(weight, min);
            max += weight;
        }

        int left = min;
        int right = max;

        int shipWeight = max;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if(isPossibleToShip(weights, days, middle)) {
                shipWeight = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return shipWeight;
    }

    private boolean isPossibleToShip(int[] weights, int days, int weight) {

        int total = 0;

        int sum = 0;
        for (var wg: weights) {
            if(wg > weight)
                return false;
            sum += wg;
            if(sum > weight) {
                total++;
                sum = wg;
            }
        }
        if(sum <= weight)
            total++;
        return total <= days;
    }
}
