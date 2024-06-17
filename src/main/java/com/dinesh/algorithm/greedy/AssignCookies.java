package com.dinesh.algorithm.greedy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies
 *
 * https://www.youtube.com/watch?v=DIX2p7vb9co
 *
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int output = 0;


        for(int i = 0; i < g.length; i++) {
            for(int j = i; j < s.length; j++) {
                if(s[j] >= g[i]) {
                    s[j] = 0;
                    output++;
                    break;
                }
            }
        }

        return output;

    }

    public int optimal(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;
        int right = 0;

        while (left < s.length && right < g.length) {
            if(g[right] <= s[left])
                right++;
            left++;
        }

        return right;

    }

}
