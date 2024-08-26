package com.dinesh.algorithm.recursion;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 */
public class PowerOfX {

    public static void main(String[] args) {

    }

    public double myPow(double x, int m) {
        long n = m;
        if(n < 0)
            n *= -1;
        double ans = 1;
        while (n > 0) {
            if( n % 2 == 1){
                ans = ans * x;
                n = n - 1;
            } else {
                x = x * x;
                n = n / 2;
            }
        }
        if(m < 0)
            return 1.0 / ans;
        return ans;
    }

    public double myPowRec(double x, int n) {
        if(n < 0)
            return 1 / pow(x, -n);
        return pow(x,n);
    }

    private double pow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;

        if(n % 2 == 0)
            return pow(x * x, n / 2);
        return x * pow(x, n-1);
    }

}
