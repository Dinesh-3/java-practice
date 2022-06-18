package thread;

/**
 * The TheadLocal construct allows us to store data that will be accessible only by a specific thread.
 *
 * Let's say that we want to have an Integer value that will be bundled with the specific thread:
 *
 * ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
 * Next, when we want to use this value from a thread, we only need to call a get() or set() method. Simply put, we can imagine that ThreadLocal stores data inside of a map with the thread as the key.
 */
public class ThreadLocalPractice {
    private static ThreadLocal<String> firstName = new ThreadLocal<>();

    public static String getFirstName() {
        return firstName.get();
    }

    public static void setFirstName(String name) {
        firstName.set(name);
    }

    public static void main(String[] args) {

    }
}
