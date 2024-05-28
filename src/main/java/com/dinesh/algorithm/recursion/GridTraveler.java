package com.dinesh.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
    public static void main(String[] args) {
        GridTraveler gridTraveler = new GridTraveler();
        Map<String, Long> memoize = new HashMap<>();
        long result = gridTraveler.gridTraveller(18,18, memoize);
        System.out.println("result = " + result);
    }

    private long gridTraveller(int n, int m, Map<String, Long> memoize) {
        String key = n + "," + m;
        if(memoize.containsKey(key))
            return memoize.get(key);
        if(n == 1 && m == 1)
            return 1;
        if(n <= 0 || m <= 0)
            return 0;

        long result =  gridTraveller(n - 1, m, memoize) + gridTraveller(n, m-1, memoize);
        memoize.put(key, result);
        return result;
    }

}
