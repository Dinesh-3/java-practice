package com.dinesh.algorithm.array;

import java.util.Arrays;

public class PlusOneInArray {
    public static void main(String[] args) {
        int[] result = plusOne(new int[]{8,9,9,9});
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] plusOne(int[] digits) {
        int last = digits[digits.length - 1];

        if(last < 9) {
            digits[digits.length - 1] = last + 1;
            return digits;
        }

        int reminder = 1;
        int index = digits.length - 1;
        while(index >= 0) {
            if(reminder > 0) {
                int sum = digits[index] + reminder;

                if(sum > 9) {
                    digits[index] = sum % 10;
                    reminder = sum / 10;
                } else {
                    digits[index] = sum;
                    reminder = 0;
                }
            }else {
                reminder = 0;
                break;
            }
            index--;
        }

        if(reminder > 0) {
            int[] copied = new int[digits.length + 1];
            copied[0] = reminder;
            for(int i = 0; i < digits.length; i++) {
                copied[i+1] = digits[i];
            }
            return copied;
        }
        return digits;
    }
}
