package com.dinesh.algorithm.math;

/**
 *
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes
 *
 * https://www.youtube.com/watch?v=g5Fuxn_AvSk
 *
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        int[] table = new int[n+1];

        for(int i = 3; i < n; i+=2)
            table[i] = 1;
        table[2] = 1;
        for(int i = 3; i*i < n; i +=2) {
            if(table[i] == 1)
                for(int j = i*i; j < n; j+=i)
                    table[j] = 0;
        }

        int count = 0;
        for(int i = 2; i < n; i++)
            count += table[i];

        return count;

    }
}
