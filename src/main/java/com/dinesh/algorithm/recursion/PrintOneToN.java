package com.dinesh.algorithm.recursion;

/**
 * Print 1 to N using recursion
 */
public class PrintOneToN {
    public static void main(String[] args) {
        printOneToN(1, 10);
    }

    private static void printOneToN(int i, int n) {
        if(i > n)
            return;
        System.out.println(i);
        printOneToN(i+1, n);
    }
}
