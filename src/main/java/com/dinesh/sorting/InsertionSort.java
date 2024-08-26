package sorting;

import java.util.Arrays;

public class InsertionSort {
    /**
     *   0  1  2  3  4
     *   |  |  |  |  |
     * [ 8, 2, 4, 1, 3 ]
     */
    public static void sort(int[] array) { // Version 2 Refactored
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current){
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = current;
        }

        System.out.println("array = " + Arrays.toString(array));
    }

    public static void sortNew(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int insertAt = i;
            while (insertAt > 0 && current < array[insertAt - 1]){
                array[insertAt] = array[insertAt - 1];
                insertAt--;
            }

            array[insertAt] = current;
        }

        System.out.println("array = " + Arrays.toString(array));
    }
}
