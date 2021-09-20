package sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        practise();
    }

    public static void sort(int[] array) {
        boolean isSorted;
        for (var i = 0; i < array.length; i++) {
            isSorted = true;
            for (var j = 1; j < array.length - i; j++)
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private  static void practise () {
        int[] numbers = { 2, 8, 1, 3, 6, 7, 5, 4 };

//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers.length; j++) {
//                if(numbers[i] < numbers[j]) { // sort ascending order, numbers[i] > numbers[j] sort descending order
//                    swap(numbers, i, j);
//                };
//            }
//        }
        for (int i = 0; i < numbers.length - 1; i++) { // Bubble Sort
            for (int j = 1; j < numbers.length - i; j++) {
                if(numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                };
            }
        }
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

}
