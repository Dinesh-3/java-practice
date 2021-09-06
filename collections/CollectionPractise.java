package collections;

import java.util.*;

/*
                                    Collection Order
                                      Collection
                                     /     |     \
                                  List   Queue    Set -> Extends Sorted Set, Tree Set
                                 /         |                   \
                    1. ArrayList   1. PriorityQueue             1. HashSet
                    2. LinkedList  queue extends Deque
                                   and ArrayDeque 2. Linked HashSet
                    3. Vector
                 -> extends stack
 */

public class CollectionPractise {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); // Doesn't throw Error. Remove's duplicate
        System.out.println(numbers);
        listPractise();
    }

    public static void listPractise() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(4);
        integers.add(2);
        integers.add(5);
        integers.add(2);

        LinkedList<Integer> integerLinkedList = new LinkedList<>(integers);
        integerLinkedList.addFirst(10);
        integerLinkedList.addLast(10); // addLast and add are same
        integerLinkedList.add(20);

        Iterator<Integer> descendingIterator = integerLinkedList.descendingIterator();
        for(int i = 0; descendingIterator.hasNext() == true; i++) {
            System.out.print(i + " = " + descendingIterator.next());
        }
        System.out.println();
        System.out.println("integerLinkedList = " + integerLinkedList);
    }

}
