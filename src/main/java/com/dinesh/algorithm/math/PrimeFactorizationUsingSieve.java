package com.dinesh.algorithm.math;

import java.util.List;
import java.util.Stack;

public class PrimeFactorizationUsingSieve {
    static final int MAXN = 200001;

    static int[] spf = new int[MAXN];

    static void sieve()
    {
        spf[0] = 0;
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = 1;

        for (int i = 2; i < MAXN; i++) {
            if (spf[i] == 1)
                for (int j = i; j < MAXN; j += i)
                    spf[j] = i;
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        Stack<Integer> stack = new Stack<>();
        while (N != 1) {
            stack.push(spf[N]);
            N = N / spf[N];
        }

        List<Integer> result = new Stack<>();

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
