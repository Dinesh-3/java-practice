package com.dinesh.algorithm.math;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPrimeFactors {
    public static void main(String[] args) {
        PrintAllPrimeFactors factors = new PrintAllPrimeFactors();
        factors.AllPrimeFactors(2);
    }
    public int[] AllPrimeFactors(int N)
    {

        List<Integer> result = new ArrayList<>();

        for(int i = 2; (i*i) <= N; i++) {
            if(N%i == 0) {
                if(isPrime(i)) {
                    result.add(i);
                }

                if(N/i != i) {
                    if(isPrime(N/i)) {
                        result.add(N/i);
                    }
                }
            }
        }

        if(isPrime(N))
            result.add(N);

        int[] arr = new int[result.size()];

        for(int i = 0; i < arr.length; i++)
            arr[i] = result.get(i);

        return arr;

    }

    private boolean isPrime(int number) {
        int count = 0;
        for(int i = 1; (i*i) <= number; i++) {
            if(number % i == 0) {
                count++;
                if(number / i != i)
                    count++;
            }

            if(count > 2)
                return false;
        }

        return count == 2;
    }

}
