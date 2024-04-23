package com.dinesh.algorithm.leetcode75;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] spells = { 5,1,3 };
        int[] potions = { 1,2,3,4,5 };
        int success = 7;

        new SuccessfulPairsOfSpellsAndPotions().successfulPairs(spells, potions, success);

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        for(int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int left = 0;
            int right = potions.length;

            int midIndex = 0;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if((long) potions[mid] * spell >= success) {
                    midIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            spells[i] = potions.length - midIndex - 1;

        }

        return spells;

    }
}
