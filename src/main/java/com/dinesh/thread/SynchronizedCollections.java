package thread;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class SynchronizedCollections {
    public static void main(String[] args) {
        List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
//        new SynchronousQueue<>()
//        Collections.synchronizedSet();
//        NavigableSet<Object> objects = Collections.synchronizedNavigableSet();
//        Collections.synchronizedSortedSet()
//
//        Collections.synchronizedMap();
//        Collections.synchronizedNavigableMap()
//        Collections.synchronizedSortedMap()

//        Collections.synchronizedCollection()
        
        Thread thread1 = new Thread(() -> {
            numbers.addAll(Arrays.asList(1, 2, 3, 5, 6, 3, 8, 7));
        });

        Thread thread2 = new Thread(() -> {
            numbers.addAll(Arrays.asList(4, 5, 6));
            Collections.sort(numbers);
        });

        thread1.start();
        thread2.start();
        System.out.println("numbers = " + numbers.size());
        try {
            thread1.join();
            thread2.join();
            System.out.println("numbers.size() = " + numbers.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("numbers = " + numbers);

    }
}
