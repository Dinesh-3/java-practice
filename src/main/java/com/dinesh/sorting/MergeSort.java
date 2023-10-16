package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array) {

        if(array.length < 2)
            return;

        int middle = array.length / 2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        sort(left);
        sort(right);

        merge(left, right, array);

    }

    private static void merge(int[] left, int[] right, int[] result) {

        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length)
        {
            if(left[leftIndex] <= right[rightIndex])
                result[resultIndex++] = left[leftIndex++];
            else
                result[resultIndex++] = right[rightIndex++];
        }

        while (leftIndex < left.length)
            result[resultIndex++] = left[leftIndex++];

        while (rightIndex < right.length)
            result[resultIndex++] = right[rightIndex++];
    }

    public static void sortOne(int[] array) {
        if (array.length < 2)
            return;

        var middle = array.length / 2;

        int[] left = new int[middle];
        for (var i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for (var i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        sortOne(left);
        sortOne(right);

        mergeOne(left, right, array);
    }

    private static void mergeOne(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        System.out.println("left = " + Arrays.toString(left) + " " + "right = " + Arrays.toString(right));
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
        System.out.println("result = " + Arrays.toString(result));
    }
}
