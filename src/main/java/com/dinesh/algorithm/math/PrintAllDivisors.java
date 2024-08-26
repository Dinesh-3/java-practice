package com.dinesh.algorithm.math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * All divisors of a Number
 * https://www.geeksforgeeks.org/problems/all-divisors-of-a-number
 *
 * https://www.youtube.com/watch?v=Ae_Ag_saG9s
 *
 */
public class PrintAllDivisors {
    public static void print_divisors(int n) {

        List<Integer> list = new ArrayList<>();

        for(int i = 1; (i*i) <= n;i++) {
            if(n % i == 0) {
                list.add(i);
                if(n / i != i)
                    list.add(n / i);
            }
        }

        list.sort(Comparator.naturalOrder());

        for(int i=0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

    }

}
