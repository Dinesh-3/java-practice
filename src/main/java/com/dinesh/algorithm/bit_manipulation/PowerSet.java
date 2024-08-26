package com.dinesh.algorithm.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] numbers = { 1,2,3 };
        System.out.println("1 << numbers.length = " + (1 << numbers.length));
        List<List<Integer>> cms = new ArrayList<>();

        for (int i = 0; i < 1 << numbers.length; i++) {
            List<Integer> set = new ArrayList<>();
            int number = i;
            int index = 0;
            while(number != 0) {
                if((number & 1) == 1)
                    set.add(numbers[index]);
                number = number >> 1;
                index++;
            }

            cms.add(set);
        }
        System.out.println("cms = " + cms);
    }
}
