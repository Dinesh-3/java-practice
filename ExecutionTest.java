package execution.time;

public class ExecutionTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i <= 100_000; i++) {
            System.out.println("LOOPED: " + i);
        }

        long end = System.currentTimeMillis();

        System.out.println((end-start) / 1000);

    }
}
