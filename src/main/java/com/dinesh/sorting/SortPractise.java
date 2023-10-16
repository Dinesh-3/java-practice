package sorting;

import java.util.Arrays;

public class SortPractise {
    public static void main(String[] args) {
        int[] numbers = { 2, 8, 1, 3, 6, 7, 5, 4 };
        InsertionSort.sort(numbers);

//        for (int i = 0; i < numbers.length; i++) { // ascending order
//            for (int j = i; j < numbers.length; j++) {
//                if(numbers[i] > numbers[j]) swap(numbers,i,j);
//            }
//        }

//        for (int i = 0; i < numbers.length; i++) { // descending order
//            for (int j = 0; j < numbers.length; j++) {
//                if(numbers[i] > numbers[j]) swap(numbers,i,j);
//            }
//        }

//        for (int i = 0; i < numbers.length; i++) { // Bubble Sort
//            for (int j = 1; j < numbers.length - i; j++) {
//                if(numbers[j] < numbers[j-1]) swap(numbers,j,j-1);
//            }
//        }

//        for (int i = 0; i < numbers.length; i++) { // Selection sort
//            int minIndex = i;
//            for (int j = i; j < numbers.length; j++) {
//                if(numbers[minIndex] > numbers[j]) minIndex = j;
//            }
//            swap(numbers, minIndex, i);
//        }
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static int binarySearchRecursion(int[] numbers, int target) {
        return binarySearchRecursion(numbers, 0, numbers.length - 1, target);
    }
    private static int binarySearchRecursion(int[] numbers, int left, int right, int target) {
        if(left > right) return -1;
            int midIndex = (left + right) / 2;
        if(numbers[midIndex] == target)
            return midIndex;
        if(numbers[midIndex] < target)
            return binarySearchRecursion(numbers, midIndex + 1, right, target);
        return binarySearchRecursion(numbers, left, midIndex - 1, target);
    }
}
