package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 2149. Rearrange Array Elements by Sign -> https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 *  https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
 */
public class RearrangeArrayElementsBySign {

    // Time -> O(2N) , Space -> O(N)
    public int[] bruteforce(int[] nums) {
        List<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        // Segregate the array into positives and negatives.
        for(int i=0;i< nums.length;i++){

            if(nums[i]>0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }

        // Positives on even indices, negatives on odd.
        for(int i=0;i<nums.length/2;i++){

            nums[2*i] = pos.get(i);
            nums[2*i+1] = neg.get(i);
        }
        return nums;

    }

    // Time -> O(N) , Space -> O(N)
    public int[] optimal(int[] nums) {
        int[] result = new int[nums.length];

        int evenIndex = 0;
        int oddIndex = 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                result[oddIndex] = nums[i];
                oddIndex += 2;
            }

        }

        return result;

    }
}
