package com.dinesh.algorithm.array;

public class SecondLargestElement {
    public static void main(String[] args) {

        int[] array = { 1, 2, 4, 7, 7, 5 };

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(max == array[i])
                continue;
            if(array[i] > max) {
                second = max;
                max = array[i];
            } else if (array[i] > second) {
                second = array[i];
            }
        }

        System.out.println("second = " + second);

    }


}
