package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1,0,1,2,-1,-4 };

        ThreeSum sum = new ThreeSum();
        sum.threeSum(nums);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;

        while(i < nums.length - 2) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            } else {
                int j = i + 1;
                int k = nums.length - 1;

                while(j < k) {
                    int sum =  nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                        while(nums[j] == nums[j+1])
                            j++;
                        while(nums[k-1] == nums[k])
                            k--;
                    } else if(sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            i++;
        }

        return result;
    }
}
