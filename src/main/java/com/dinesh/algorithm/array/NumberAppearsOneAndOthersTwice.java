package com.dinesh.algorithm.array;

public class NumberAppearsOneAndOthersTwice {
    public static void main(String[] args) {
        int[] numbers = { 4,1,2,1,2 };

        int xor = 0;
        for (int number : numbers)
            xor = xor ^ number;

        System.out.println("xor = " + xor);
    }
}
