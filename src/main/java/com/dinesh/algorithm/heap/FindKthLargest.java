package com.dinesh.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> topKelements=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(topKelements.size()<k || topKelements.peek()<nums[i]){
                topKelements.add(nums[i]);
            }
            if(topKelements.size()>k){
                topKelements.poll();
            }
        }
        return topKelements.peek();
    }
}
