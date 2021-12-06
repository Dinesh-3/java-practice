package collections;

import java.util.*;

/**
                                        Collection Order
                                            Collection
                                     /          |         \
                                  List       Queue        Set -> Implementation
                                 /            |                        \
                    1. ArrayList   1. PriorityQueue             1. HashSet
                    2. LinkedList  Deque<E> extends Queue<E>    2. Linked HashSet
                    3. Vector               |                   3. Sorted Set -> implementation Tree Set
            ->  Stack extends Vector   Implementation ArrayDeque
                                    AbstractQueue,
                                    ArrayBlockingQueue,
                                    ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue,
                                    DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue,
                                    LinkedList, LinkedTransferQueue, PriorityBlockingQueue,
                                    PriorityQueue, SynchronousQueue


    Topics:
    1. Fail fast and fail safe -> https://www.geeksforgeeks.org/fail-fast-fail-safe-iterators-java/
 */

public class CollectionPractise {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); // Doesn't throw Error. Remove's duplicate
        System.out.println(numbers);
        listPractise();
        collection();
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

    public static void  collection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");

        // Add multiple items in one go
        Collections.addAll(collection, "a", "b", "c");
        System.out.println("collection = " + collection);
        var size = collection.size();

        collection.remove("a");
        var containsA = collection.contains("a");

        collection.clear();
        var isEmpty = collection.isEmpty();

        Object[] objectArray = collection.toArray();
        String[] stringArray = collection.toArray(new String[0]);

        Collection<String> other = new ArrayList<>();
        other.add("a");
        other.add("b");
        other.add("c");
        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }
}
