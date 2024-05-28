package com.dinesh.algorithm.array;
import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * 56. Merge Intervals
 * https://www.youtube.com/watch?v=IexN60k62jo
 *https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 */
public class MergeIntervals {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> nums = new ArrayList<>();

        int startRange = -1;
        int endRange = -1;

        for(int i = 0; i < intervals.length; i++) {

            if(nums.size() > 0 && intervals[i][1] <= nums.get(nums.size() - 1)[1])
                continue;

            int start = intervals[i][0];
            int end = intervals[i][1];

            if(startRange == -1) {
                startRange = start;
                endRange = end;
            } else if(endRange >= start) {
                endRange = Math.max(Math.max(start, end), endRange);
            } else {
                int[] range = { startRange, endRange };
                nums.add(range);
                startRange = start;
                endRange = end;
            }
        }

        if(nums.size() <= 0 || endRange > nums.get(nums.size() - 1)[1]) {
            int[] range = { startRange, endRange };
            nums.add(range);
        }

        int[][] result = new int[nums.size()][2];

        for(int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }

        return result;
    }



}
