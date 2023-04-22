package collections;

import java.util.*;

public class CollectionsPractice {
    public static void main(String[] args) {

        List<String> fruitsList = new ArrayList<>(List.of("Mango", "Apple", "Banana"));
        Set<String> fruitsSet = new HashSet<>(List.of("Orange", "apple"));

        /**
         * Returns true if the two specified collections have no elements in common.
         * Note: String case-insensitive
         * Throws
         * 1. NullPointerException - if either collection is null.
         * 2. NullPointerException - if one collection contains a null element and null is not an eligible
         *    element for the other collection.
         * 3. ClassCastException - if one collection contains an element that is of a type which is ineligible
         *    for the other collection.
         */
        boolean disjoint = Collections.disjoint(fruitsList, fruitsSet);
        System.out.println("disjoint = " + disjoint);


    }
}
