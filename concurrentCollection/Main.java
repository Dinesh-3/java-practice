package concurrentCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        /**
         * Synchronized collection are blocking collection low performance
         * Concurrent collection are efficient high performance uses lock stripping mechanism
         */
        concurrentHashMapVSHashMap();
    }

    private static void concurrentHashMapVSHashMap() {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> cMap = new ConcurrentHashMap<>();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    int random = (int) (Math.random() * 10);
                    map.put(random, map.getOrDefault(random, 0) + 1);
                    cMap.put(random, cMap.getOrDefault(random, 0) + 1);
                }
            });
            threads.add(thread);
        }

        for(var thread: threads) {
            thread.start();
        }

        for (var thead: threads) {
            try {
                thead.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("map = " + map);
        System.out.println("cMap = " + cMap);

    }
}
