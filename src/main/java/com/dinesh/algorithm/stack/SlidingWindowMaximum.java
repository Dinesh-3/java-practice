package com.dinesh.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum
 *
 * https://takeuforward.org/data-structure/sliding-window-maximum/
 * https://www.youtube.com/watch?v=NwBvene4Imo
 *
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> queue = new LinkedList<>();

        int index = 0;
        for(int i = 0; i < n; i++) {
            if(!queue.isEmpty() && queue.getFirst() <= (i-k))
                queue.removeFirst();

            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i])
                queue.removeLast();

            queue.addLast(i);
            if(i >= (k - 1))
                res[index++] = nums[queue.getFirst()];
        }

        return res;
    }
}
