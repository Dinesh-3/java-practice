package com.dinesh.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * https://leetcode.com/problems/valid-parenthesis-string
 */
public class ValidParanthesisChecker {

    class Comp implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    }

    public boolean checkValidString(String s) {

        int min = 0;
        int max = 0;
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                min += 1;
                max += 1;
            }
            if(ch == ')') {
                min -= 1;
                max -= 1;
            }

            if(ch == '*') {
                min -= 1;
                max += 1;
            }
            if(max < 0)
                return false;

            if(min < 0)
                min = 0;
        }

        return min == 0 && max >= 0;

    }

}
