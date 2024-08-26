package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 4)
            return result;

        Arrays.sort(nums);

        int i = 0;

        while(i < nums.length) {
            int j = i + 1;
            while (j < nums.length) {

                int k = j + 1;
                int l = nums.length - 1;

                while(k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if(sum == target)
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));

                    if(sum <= target) {
                        k++;
                        while(k < nums.length && nums[k] == nums[k-1])
                            k++;
                    }

                    if(sum >= target) {
                        l--;
                        while(l >= 0 && nums[l] == nums[l+1])
                            l--;
                    }

                }

                j++;
                while(j < nums.length && nums[j] == nums[j-1])
                    j++;
            }

            i++;
            while(i < nums.length && nums[i] == nums[i-1])
                i++;
        }

        return result;

    }
}
