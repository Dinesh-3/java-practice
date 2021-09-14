package sorting;

import java.util.List;

public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[j] < array[j-1]) {
                    swap(array, i, j -1 );
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
