package com.dinesh.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithXORByK {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        int B = 6;
        SubArrayWithXORByK xorByK = new SubArrayWithXORByK();
        xorByK.solve(A, B);
    }
    public int solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xor = A[0];

        int count = 0;
        for(int i = 1; i < A.length; i++) {
            xor = xor ^ A[i];
            if(map.containsKey(xor^B))
                count++;
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;

    }

}
