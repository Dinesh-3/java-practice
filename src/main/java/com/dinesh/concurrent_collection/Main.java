package concurrent_collection;

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
         * https://stackoverflow.com/questions/16151606/need-simple-explanation-how-lock-striping-works-with-concurrenthashmap
         */
        concurrentHashMapVSHashMap();
    }

    private static void concurrentHashMapVSHashMap() {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> cMap = new ConcurrentHashMap<>();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100_00; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                map.put(finalI, map.getOrDefault(finalI, 0) + 1);
                cMap.put(finalI, cMap.getOrDefault(finalI, 0) + 1);
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

        System.out.println("map = " + map.size());
        System.out.println("cMap = " + cMap.size());

    }
}
