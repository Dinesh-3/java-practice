package com.dinesh.algorithm.math;

/**
 *
 * 1922. Count Good Numbers
 * https://leetcode.com/problems/count-good-numbers
 *
 */
public class CountGoodNumbers {
    static final long MOD = (long)(1e9 + 7);

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n+1) / 2;

        return (int)(pow(5,even) * pow(4,odd) % MOD);

    }

    public long pow(long x, long n){

        if(n==0)
            return 1;

        long temp = pow(x,n/2);

        if(n%2==0)
            return (temp * temp)% MOD;
        return (x * temp * temp)% MOD;
    }
}
