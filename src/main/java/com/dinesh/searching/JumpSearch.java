package com.dinesh.searching;

public class JumpSearch {
    public static void main(String[] args) {
        int[] numbers = {2, 5};

        int index = findIndex(numbers, 5);

        System.out.println("index = " + index);
    }

    private static int findIndex(int[] numbers, int target) {
        int blockLength = (int) Math.sqrt(numbers.length);

        int start = 0;
        int next = blockLength;
        while (start < numbers.length && numbers[next - 1] < target) {
            start = next;
            next = next + blockLength;

            if(next > numbers.length)
                next = numbers.length;
        }

        for (int i = start; i < next; i++) {
            if(numbers[i] == target)
                return i;
        }
        return -1;
    }
}
