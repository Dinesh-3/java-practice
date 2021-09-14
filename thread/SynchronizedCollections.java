package thread;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class SynchronizedCollections {
    public static void main(String[] args) {
        Collection<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
//        new SynchronousQueue<>()
        Thread thread1 = new Thread(() -> {
            numbers.addAll(Arrays.asList(1, 2, 3, 5, 6, 3, 8, 7));
        });

        Thread thread2 = new Thread(() -> {
            numbers.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("numbers = " + numbers);

    }
}
