package sorting;

import java.util.Arrays;

public class SortMain {
    public static void main(String[] args) {
//        int[] numbers = { 3, 1, 2 };
//
//        BubbleSort.sort(numbers);
//
//        System.out.println("numbers = " + Arrays.toString(numbers));
//        int[] selectionSort = { 8, 2, 4, 1, 3 };
//        SelectionSort.sort(selectionSort);
//        System.out.println("selectionSort = " + Arrays.toString(selectionSort));

        int[] mergeSort = { 8, 2, 4, 1, 3 };
        MergeSort.sort(mergeSort);
        System.out.println("selectionSort = " + Arrays.toString(mergeSort));
    }
}
