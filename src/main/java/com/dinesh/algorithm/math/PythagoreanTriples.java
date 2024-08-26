package com.dinesh.algorithm.math;

public class PythagoreanTriples {

    public static void main(String[] args) {
        int maxVal = 100;
        findPythagoreanTriples(maxVal);
    }

    public static void findPythagoreanTriples(int maxVal) {
        for (int a = 1; a < maxVal; a++) {
            for (int b = a; b < maxVal; b++) {
                double c = Math.sqrt(a * a + b * b);
                if (c == (int) c) {
                    System.out.println("a: " + a + ", b: " + b + ", c: " + (int) c);
                }
            }
        }
    }
}
