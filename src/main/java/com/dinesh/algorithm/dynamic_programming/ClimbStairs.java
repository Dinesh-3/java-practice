package com.dinesh.algorithm.dynamic_programming;

import java.util.*;

/**
 *
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs
 *
 * https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
 * https://www.youtube.com/watch?v=mLfjzJsN8us
 *
 */
public class ClimbStairs {

    public int climbStairsTabulation(int n) {
        int prev1 = 1;
        int prev2 = 0;

        for(int i = 1; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }


    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climb(n, map);
    }

    private int climb(int n, Map<Integer, Integer> map) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(map.containsKey(n))
            return map.get(n);

        int res = climb(n-1, map) + climb(n-2, map);
        map.put(n, res);
        return res;
    }

}
