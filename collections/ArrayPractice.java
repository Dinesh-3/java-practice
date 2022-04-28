package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * Points:
 * 1. Fixed in size
 * 2. Fast for data retrieval
 * 3. Compact memory usage if we know the size
 * 4. 2d, 3d arrays
 * Disadvantages:
 * 1. If array is full we need to copy the entire array to new big size array O(N)
 * 2. Delete operation is hard
 *
 */
public class ArrayPractice {
    public static void main(String[] args) {
        int[] numbers = {3, 8, 4, 7, 2, 1};
        int[] numbers1 = {3, 8, 2, 7, 4, 1};

//        numbers.length = 10; // Throws cannot assign a value to final variable length.Because arrays are fixed in size

        int[] randomIntegers = new int[10];
        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = (int) (Math.random() * 10);
        }
        String integersString = Arrays.toString(randomIntegers);
        System.out.println("integersString = " + integersString);

        /**
         * Arrays Class Static methods
         * All methods are Overloaded with byte, short, int, long, float, double, boolean, char, Object
         */

        List<Integer> integerList = Arrays.stream(randomIntegers).boxed().collect(Collectors.toList());
        Arrays.stream(numbers, 0, 3).peek(number -> System.out.println(number)).toArray();

//        Arrays.asList();
//        List.of();

        String[] names = new String[10];
//        Arrays.fill(names, "Dinesh");
        Arrays.fill(names, 0, 2, "Dinesh"); // toExclusive
        System.out.println("names = " + Arrays.toString(names));

        Arrays.sort(numbers);
        System.out.println("Sorted numbers = " + Arrays.toString(numbers));
//        Arrays.sort(names, String::compareTo); // throws null pointer exception if any null value passed

//        int[] ints = Arrays.copyOf(numbers, numbers.length + (numbers.length) / 2);
        int[] ints = Arrays.copyOf(numbers, numbers.length);
        int[] intCopyOfRange = Arrays.copyOfRange(numbers, 0, 2);
        System.out.println("intCopyOfRange = " + Arrays.toString(intCopyOfRange));

        System.out.println("Arrays.equals(numbers, ints) = " + Arrays.equals(numbers, ints));

        System.out.println("Arrays.compare(numbers, ints) = " + Arrays.compare(numbers, ints));
        System.out.println("Arrays.compare(numbers, intCopyOfRange) = " + Arrays.compare(numbers, intCopyOfRange)); // returns length difference
        // Return the index which two arrays differ
        System.out.println("Arrays.mismatch(numbers, ints) = " + Arrays.mismatch(numbers, ints));
        System.out.println("Arrays.mismatch(numbers, numbers1) = " + Arrays.mismatch(numbers, numbers1));

        int hashCode = Arrays.hashCode(numbers);
        System.out.println("hashCode = " + hashCode);

        System.out.println("Arrays.binarySearch(numbers, 3) = " + Arrays.binarySearch(numbers, 3));

        // For 2D or multi dimensional array
//        Arrays.deepEquals();
//        Arrays.deepHashCode();
//        Arrays.deepToString();

        Arrays.setAll(numbers, number -> number * number); // it will change existing array
        System.out.println("squared number = " + Arrays.toString(numbers));

        Arrays.parallelSort(numbers);
        Arrays.parallelSort(numbers, 0, 2);

        Spliterator.OfInt spliterator = Arrays.spliterator(numbers);

        System.out.println("\n--- ARRAY OPERATION ---\n");
        final String[] MONTHS = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        System.out.println(MONTHS);
        System.out.println(List.of(MONTHS));
        System.out.println(Arrays.asList(MONTHS));

    }
}
