package com.dinesh.algorithm.array;

public class MaxSum {
    public static void main(String[] args) {
        int n = 4;
        int a[] = {8, 3, 1, 2};
        int sum = 0;

        for(int i = 0; i < a.length; i++) {

            int cur = 0;
            for(int j = i; j < a.length; j++)
                cur += a[j] * (j-i);

            int in = a.length - i;
            for(int k = 0; k < i; k++)
                cur += a[k] * (in++);

            sum = Math.max(cur, sum);
        }
        System.out.println("sum = " + sum);
//        return sum;
    }
}
