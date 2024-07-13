package com.dinesh.algorithm.basics;

/**
 * GCD == HCF
 */
public class GCDAndLCMAndHCF {
    public static void main(String[] args) {
        int num1 = 15;
        int num2 = 20;

        int result = lcm(num1, num2);
        System.out.println("The LCM of " + num1 + " and " + num2 + " is: " + result);
    }

    public static int gcdOptimal(int a, int b) {
        while (a > 0 && b > 0) {
            if(a > b) a = a % b;
            else b = b % a;
        }
        if(a == 0)
            return b;
        return a;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
