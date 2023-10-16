package sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortMain {
    private static int size = 10_000_000;
    public static void main(String[] args) throws IOException {
        sort();
        System.out.println("MERGE SORT");
        int[] mergeSort = {2, 8, 1, 7, 5, 4, 6};
        sorting.MergeSort.sort(mergeSort);
        System.out.println(" = MERGE SORT RESULT = " + Arrays.toString(mergeSort));
//        long selectionStart = System.currentTimeMillis();
//        int[] selectionSort = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 1_000_000))
//                .distinct()
//                .limit(size).toArray();
////        System.out.println("array = " + Arrays.toString(selectionSort));
//        SelectionSort.sort(selectionSort);
//        long selectionEnd = System.currentTimeMillis();
//        System.out.println("SELECTION Time Taken: " + (selectionEnd-selectionStart));
//        System.out.println("selectionSort = " + Arrays.toString(selectionSort));

//        int[] numbers = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 100)).limit(size).toArray();
//        long bubbleStart = System.currentTimeMillis();
//        BubbleSort.sort(numbers);
//        long bubbleEnd = System.currentTimeMillis();
//        System.out.println("BUBBLE Time Taken: " + (bubbleEnd-bubbleStart) );
////        System.out.println("numbers = " + Arrays.toString(numbers));
//
//
//
//                IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 100_000_000))
//                .distinct()
//                .limit(size).toArray();

//        var unsortedNumbers = Arrays.toString(mergeSort).replaceAll("\\[(.*)\\]", "$1");
//        FileWriter fileWriter = new FileWriter("/home/dinesh/Downloads/Java Practice/searching/unsortedNumbers.csv");
//        fileWriter.append(unsortedNumbers);
//        fileWriter.close();
//        fileWriter = null;
//        System.out.println(fileWriter);
//        System.gc();

        long mergeStart = System.currentTimeMillis();
        //MergeSort.sort(mergeSort);
        long mergeEnd = System.currentTimeMillis();
        System.out.println("MERGE Time Taken: " + (mergeEnd-mergeStart));

//        FileWriter fileWriter1 = new FileWriter("/home/dinesh/Downloads/Java Practice/searching/sortedNumbers.csv");
//        fileWriter1.append(Arrays.toString(mergeSort).replaceAll("\\[(.*)\\]", "$1"));
//        fileWriter1.close();

        System.out.println("mergeSort = " + Arrays.toString(mergeSort));
//
//        int[] quickSort = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 100)).limit(size).toArray();
//        long quickStart = System.currentTimeMillis();
//        QuickSort quickSort1 = new QuickSort();
//        quickSort1.sort(quickSort);
//        long quickEnd = System.currentTimeMillis();
//        System.out.println("QUICK Time Taken: " + (quickEnd-quickStart));
////        System.out.println("quickSort = " + Arrays.toString(quickSort));
    }

    private static void sort() {
        int[] mergeSort = {2, 4, 2323, 8, 1, 7, 5, 4};

        sorting.InsertionSort.sortNew(mergeSort);

        System.out.println("ANs = " + Arrays.toString(mergeSort));
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
