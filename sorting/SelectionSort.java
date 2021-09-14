package sorting;

public class SelectionSort {
//    public static void sort(int[] array) { // Version 1
//        int sortedIndex = 0;
//        for (int i = 0; i < array.length; i++) {
//            int min = Integer.MAX_VALUE;
//            int swapIndex = 0;
//            for (int j = sortedIndex; j < array.length; j++) {
//                if(array[j] < min) {
//                    min = array[j];
//                    swapIndex = j;
//                };
//            }
//            swap(array, sortedIndex , swapIndex);
//            ++sortedIndex;
//        }
//    }

    public static void sort(int[] array) { // Version 2 Refactored
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if(array[j] < array[minIndex]) minIndex = j;
            }
            swap(array, minIndex , i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
