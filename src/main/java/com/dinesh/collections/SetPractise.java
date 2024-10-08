package collections;

import java.util.*;

/**
            Set
             |
            HashSet
            LinkedHashSet
    TreeSet implements SortedSet
    public interface SortedSet<E> extends Set<E> {

 Set -> HashSet, Linked HashSet

 SortedSet, TreeSet

 */
public class SetPractise {
    public static void main(String[] args) {

        /**
         * HashSet
         * Points:
         *  1. Contains unique elements
         *  2. Internally uses HashMap
         *  3. Accepts only one null value
         *  4. Unordered -> Elements are shuffled so accessing element by index not support
         */
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Set<Integer> hashSet = new HashSet<>(Arrays.asList(nums));
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.toArray() = " + Arrays.toString(hashSet.toArray()));
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println("hashSet.isEmpty() = " + hashSet.isEmpty());
        System.out.println("hashSet.remove(4) = " + hashSet.remove(4));

        String[] fruits = {"banana", "orange", "date", "apple", "cherry"};
        Set<String> set = new HashSet<>(List.of(fruits));
        System.out.println("set = " + set);

        /**
         *      LinkedHashSet
         *
         *  It uses a HashTable and doubly linked list to store and maintain the insertion order of the elements.
         *
         * Points:
         *  1. It's preserves insertion order
         *  2. Internally uses doubly linked list
         *  3. Ordered version of Set
         */

        Set<String> linkedHashSet = new LinkedHashSet<>(List.of(fruits));
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println("linkedHashSet.isEmpty() = " + linkedHashSet.isEmpty());
        System.out.println("linkedHashSet.remove(12) = " + linkedHashSet.remove("12"));
        System.out.println("linkedHashSet.add(mango) = " + linkedHashSet.add("mango"));
        System.out.println("linkedHashSet.contains(mango) = " + linkedHashSet.contains("mango"));
        System.out.println("linkedHashSet = " + linkedHashSet);

        /**
         *      SortedSet
         *      public interface SortedSet<E> extends Set<E>
         * Implementation -> TreeSet -> Self balancing binary search tree like Red-Black Tree
         * Points:
         *  1. items must implement comparable interface
         *  2. It's sort the element in ascending order
         *  3. Doesn't allow null value
         */
        System.out.println("--- TREE SET ---");
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(34);
        sortedSet.add(4);
        sortedSet.add(3);
        sortedSet.add(10);
//        sortedSet.add(null); // Throws error
        System.out.println("sortedSet = " + sortedSet);
        System.out.println("sortedSet.first() = " + sortedSet.first());
        System.out.println("sortedSet.last() = " + sortedSet.last());
        System.out.println("sortedSet.tailSet(2) = " + sortedSet.tailSet(2)); // not index it's int value stored inclusive return elements >= 2
        System.out.println("sortedSet.headSet(3) = " + sortedSet.headSet(3)); // exclusive elements < 3
        System.out.println("sortedSet.subSet(1,3) = " + sortedSet.subSet(1, 3)); // (inclusive, exclusive) element btw 1 2
        System.out.println("sortedSet = " + sortedSet);

        SortedSet<String> sortedStringSet = new TreeSet();
        sortedStringSet.add("Apple");
        sortedStringSet.add("Orange");
        sortedStringSet.add("1");
        sortedStringSet.add("Banana");
        sortedStringSet.add("3");
        Object o = new Object();
        System.out.println("o.equals(2) = " + o.equals(2));

        System.out.println("sortedStringSet.headSet(\"Cake\") = " + sortedStringSet.headSet("Cake")); // case sensitive

        Set<String> set1 =
                new HashSet<>(Arrays.asList("a", "b", "c"));

        Set<String> set2 =
                new HashSet<>(Arrays.asList("b", "c", "d"));

        // Union
//        set1.addAll(set2);
//        System.out.println("addAll() set1 = " + set1);

        // Intersection or common element
//        set1.retainAll(set2);
//        System.out.println("retainAll() set1 = " + set1);

//        // Difference
        set1.removeAll(set2);
        System.out.println("removeAll() set1 = " + set1);

    }
}
