package collections;

import java.util.*;

/**
            Set
             |
            HashSet
            LinkedHashSet
    TreeSet implements SortedSet
    public interface SortedSet<E> extends Set<E> {
 */
public class SetPractise {
    public static void main(String[] args) {

        /**
         * HashSet
         * Points:
         *  1. Contains unique elements
         *  2. Internally uses HashMap -> Uses HashTable
         *  3. Accepts only one null value
         *  4. Unordered -> Elements are shuffled so accessing element by index not support
         */
        Set<Integer> hashSet = new HashSet<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("hashSet = " + hashSet);

        /**
         *      LinkedHashSet
         * Points:
         *  1. It's preserves insertion order
         *  2. Internally uses doubly linked list
         *  3. Ordered version of HashSet
         */
        Set<Integer> linkedHashSet = new LinkedHashSet<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("linkedHashSet = " + linkedHashSet);

        /**
         *      SortedSet
         *      public interface SortedSet<E> extends Set<E>
         * Implementation -> TreeSet -> Self balancing binary search tree like Red-Black Tree
         * Points:
         *  1. items must implement comparable interface
         *  2. It's sort the element in ascending order
         */
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(1);
        sortedSet.add(4);
        sortedSet.add(1);
        sortedSet.add(2);
        sortedSet.add(3);

//        SortedSet<String> sortedSet = new TreeSet();
//        sortedSet.add("1");
//        sortedSet.add("4");
//        sortedSet.add("1");
//        sortedSet.add("2");
//        sortedSet.add("3");

        System.out.println("sortedSet = " + sortedSet);

        Set<String> set1 =
                new HashSet<>(Arrays.asList("a", "b", "c"));

        Set<String> set2 =
                new HashSet<>(Arrays.asList("b", "c", "d"));

        // Union
        set1.addAll(set2);
        System.out.println(set1);
        // Intersection
        set1.retainAll(set2);
        System.out.println(set1);
        // Difference
        set1.removeAll(set2);
        System.out.println(set1);

    }
}
