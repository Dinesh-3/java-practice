package thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentCollections {
    public static void main(String[] args) {

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();



        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
    }
}
