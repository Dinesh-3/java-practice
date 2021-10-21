package thread;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollections {
    public static void main(String[] args) {
        /**
         * Interfaces:
         *  1. ConcurrentMap -> ConcurrentHashMap
         *  2. ConcurrentNavigableMap -> Implementation ConcurrentSkipListMap
         */
        Map<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentSkipListMap<Object, Object> skipListMap = new ConcurrentSkipListMap<>();

        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

        ConcurrentLinkedQueue<Object> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

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
