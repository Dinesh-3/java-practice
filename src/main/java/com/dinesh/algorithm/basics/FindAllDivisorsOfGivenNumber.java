package com.dinesh.algorithm.basics;

import java.util.ArrayList;
import java.util.List;

public class FindAllDivisorsOfGivenNumber {
    public static void main(String[] args) {
        List<Integer> divisors = getDivisors(36);
        System.out.println("divisors = " + divisors);
    }

    private static List<Integer> getDivisors(int num) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(num); i++) {
            int second = num / i;
            if(num % i == 0) {
                divisors.add(i);
                if(i != second)
                    divisors.add(second);
            }
        }
        return divisors;
    }
}
