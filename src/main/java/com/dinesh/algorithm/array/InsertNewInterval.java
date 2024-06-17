package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * https://www.youtube.com/watch?v=xxRE-46OCC8
 *
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 *
 */
public class InsertNewInterval {

    public static void main(String[] args) {
        int[][] intervals = {{ 1,5 }};
        int[] newInterval = {0,3};

        InsertNewInterval interval = new InsertNewInterval();
        interval.insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int startIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            if(startIndex == -1 && intervals[i][1] >= newInterval[0]) {
                if(intervals[i][0] < newInterval[0]) {
                    list.add(intervals[i]);
                    list.add(newInterval);
                } else {
                    list.add(newInterval);
                    list.add(intervals[i]);
                }
                startIndex = i;
            } else {
                list.add(intervals[i]);
            }
        }

        if(startIndex == -1)
            list.add(newInterval);

        return mergeIntervals(list);

    }

    public int[][] mergeIntervals(List<int[]> intervals) {

        if(intervals.size() <= 1) {
            int[][] result = new int[intervals.size()][2];
            for(int i = 0; i < intervals.size(); i++)
                result[i] = intervals.get(i);
            return result;
        }

        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];

        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < intervals.size(); i++) {
            int[] range = intervals.get(i);
            if(end >= range[0])
                end = Math.max(range[1], end);
            else {
                list.add(new int[] { start, end });
                start = range[0];
                end = range[1];
            }
        }

        list.add(new int[] { start, end });

        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}
