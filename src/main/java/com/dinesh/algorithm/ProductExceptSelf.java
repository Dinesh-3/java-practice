package com.dinesh.algorithm;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4 };

        int[] result = new int[numbers.length];

        int prefix = 1;
        for (int i = 0; i < numbers.length; i++) {
            result[i] = prefix;
            prefix *= numbers[i];
        }

        int postFix = 1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            result[i] *= postFix;
            postFix *= numbers[i];
        }

        System.out.println("result = " + Arrays.toString(result));
    }
}
