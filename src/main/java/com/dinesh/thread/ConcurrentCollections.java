package thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConcurrentCollections {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Interfaces:
         *  1. ConcurrentMap -> ConcurrentHashMap
         *  2. ConcurrentNavigableMap -> Implementation ConcurrentSkipListMap
         */
        ConcurrentMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentNavigableMap<Object, Object> skipListMap = new ConcurrentSkipListMap<>();

        ConcurrentLinkedQueue<Object> linkedQueue = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedDeque<Object> linkedDeque = new ConcurrentLinkedDeque<>();

        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

//        concurrentSet(set);

        hashMap(concurrentHashMap);
        hashMap(skipListMap);

//        queue(linkedQueue);
//        queue(linkedDeque);

    }

    private static void queue(Queue<Object> queue) throws InterruptedException {
        int size = 100_000;
        List<Thread> threads = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            int number = i;
            var thread = new Thread(() -> {
                queue.add(number);
            });
            threads.add(thread);
        }

        for (var thread: threads) thread.start();
        for (var thread: threads) thread.join();
//        System.out.println("map = " + map);
        System.out.println(String.format("%s size %s", queue.getClass().getName(), queue.size()));
    }

    private static void hashMap(ConcurrentMap<Object, Object> map) throws InterruptedException {
        int size = 100_000;
        List<Thread> threads = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
//            int number = i;

            var thread = new Thread(() -> {
                IntStream.rangeClosed(1, 100).peek((item) -> map.put(item, item)).toArray();
//               map.put(number, number);
            });
            threads.add(thread);
        }

        for (var thread: threads) thread.start();
        for (var thread: threads) thread.join();

        System.out.println("map = " + map);
        System.out.printf("%s size %s%n", map.getClass().getName(), map.values().size());
    }

    private static void concurrentSet(ConcurrentSkipListSet<Integer> set) {
        List<Thread> threads = new ArrayList<>();
        int n = 1_000;
        for (int i = 0; i < n; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                set.add(finalI);
//                (int) Math.round(Math.random()*n)
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("set = " + set.size());
    }
}
