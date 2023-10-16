package sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] numbers = { 2, 8, 1, 7, 5, 4 };
        sort(numbers, 100);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }
    public static void sort(int[] array, int max) {
        int[] counts = new int[max + 1];
        for (var item : array)
            counts[item]++;
        System.out.println("counts = " + Arrays.toString(counts));
        var k = 0;
        for (var i = 0; i < counts.length; i++)
            for (var j = 0; j < counts[i]; j++)
                array[k++] = i;
    }
}
