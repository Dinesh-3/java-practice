package com.dinesh.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NMettingsInOneRoom {

    static class Comp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[1] < o2[1])
                return -1;
            if(o1[1] > o2[1])
                return 1;
            if(o1[2] < o2[2])
                return -1;
            return 1;
        }
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] sets = new int[n][3];

        for(int i = 0; i < start.length; i++) {
            int[] row = sets[i];
            row[0] = start[i];
            row[1] = end[i];
            row[2] = i + 1;
        }

        Arrays.sort(sets, new Comp());

        int endTime = sets[0][1];
        int count = 1;
        for(int i = 1; i < sets.length; i++) {
            if(sets[i][0] > endTime) {
                endTime = sets[i][1];
                count++;
            }
        }

        return count;

    }
}
