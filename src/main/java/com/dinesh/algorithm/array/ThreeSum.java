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
        int len = nums.length;
        Arrays.sort(nums);

        int left = 0;

        List<List<Integer>> result = new ArrayList<>();

        while(left < nums.length - 2) {
            int mid = left + 1;
            int right = nums.length - 1;
            while(mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if(sum == 0)
                    result.add(new ArrayList<>(List.of(nums[left] , nums[mid] , nums[right])));

                if(sum <= 0) {
                    mid++;
                    while(mid < right && nums[mid] == nums[mid-1])
                        mid++;
                }


                if(sum >= 0) {
                    right--;
                    while(mid < right && nums[right] == nums[right+1])
                        right--;
                }

            }

            left++;
            while(left < len && nums[left] == nums[left-1])
                left++;
        }

        return result;

    }
}
