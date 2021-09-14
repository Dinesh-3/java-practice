package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  QUEUE
 *  FrontEnd -> Remove
 *  RearEnd -> Add
 */
public class QueuePractise {

    public static void main(String[] args) {

        /**
         *
         *   Deque -> Double Ended Queue Item can be added and removed from both end
         *   public interface Deque<E> extends Queue<E>
         *   Implementation: ArrayDeque -> Resizable Array, no capacity restrictions
         *
         *          We have alternative methods that don't
         *          throw an exception:
         *
         *          offer() similar to add()
         *          poll() similar to remove()
         *          peek() similar to element()
         */
        Deque<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        queue.remove();
        queue.removeLast();
        queue.addLast("d");
        var front = queue.remove();

        front = queue.element(); // Throws error if queue is Empty

        System.out.println(front);
        System.out.println(queue);

        /**
         * Priority Queue
         * Initial Capacity -> 11
         *  High priority elements served first irrespective of an insertion order
         *  Ascending Order
         */
        Queue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.add(4);
        integers.add(0);
        integers.add(2);
        integers.add(3);
        System.out.println("integers.element() = " + integers.element());
        System.out.println("integers.remove() = " + integers.remove());
        System.out.println("integers.element() = " + integers.element());
        
        System.out.println("integers = " + integers);

    }
}
