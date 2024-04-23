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
        for(int i = 0; descendingIterator.hasNext(); i++) {
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

//        collection.clear();
        var isEmpty = collection.isEmpty();

        Object[] objectArray = collection.toArray();
        String[] stringArray = collection.toArray(new String[0]);

        System.out.println("collection = " + collection);
        System.out.println("objectArray = " + Arrays.toString(objectArray));
        System.out.println("stringArray = " + Arrays.toString(stringArray));

        Collection<String> other = new ArrayList<>();
        other.add("a");
        other.add("b");
        other.add("c");
        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }

    /**
     *  QUEUE
     *  FrontEnd -> Remove
     *  RearEnd (or) Last -> Add (Rear == Back)
     */
    public static class QueuePractise {

        public static void main(String[] args) {

            /**
             *   Deque -> Double Ended Queue Item can be added and removed from both end
             *   public interface Deque<E> extends Queue<E>
             *   Implementation: ArrayDeque -> Resizable Array, no capacity restrictions, Default Array Size = 16
             *
             *          We have alternative methods that don't
             *          throw an exception:
             *
             *          offer() similar to add()
             *          poll() similar to remove()
             *          peek() similar to element()
             */
            Queue<String> queue = new ArrayDeque<>();
            queue.add("c");
            queue.add("a");
            queue.add("b");
            queue.remove(); // Removes first
            var front = queue.remove();
            List<Integer> room = new ArrayList<>();
            front = queue.element(); // Throws error if queue is Empty

            System.out.println(front);
            System.out.println(queue);

            /**
             * Priority Queue
             * Initial Capacity -> 11
             *  High priority elements served first irrespective of an insertion order
             *  Ascending Order
             */
            System.out.println("--- PRIORITY QUEUE ---");
            Queue<Integer> integers = new PriorityQueue<>();
            integers.add(1);
            integers.add(4);
            integers.add(0);
            integers.add(2);
            integers.add(3);
            Integer peeked = integers.peek();

            Queue<Integer> minHeap = new PriorityQueue<>(); // ascending order || smallest element has high priority
            Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // descending order

            int n = 10;
            for (int i = 0; i < n; i++) {
                int number = (int) Math.round(Math.random()*n);
                minHeap.add(number);
                maxHeap.add(number);
            }

            System.out.println("minHeap = " + minHeap);
            System.out.println("maxHeap = " + maxHeap);

            System.out.println("integers = " + integers);
            System.out.println("integers.element() = " + integers.element());
            System.out.println("integers.remove() = " + integers.remove());
            System.out.println("integers.element() = " + integers.element());

        }
    }
}
