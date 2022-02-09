package thread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadScheduler {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        beepForAnHour();
    }

    public static void beepForAnHour() {
        Runnable beeper = () -> {
            Map<String, String> getenv = System.getenv();
            Properties properties = System.getProperties();
//            System.out.println("getenv = " + getenv);
            System.out.println("properties = " + properties);
            System.setProperty("abs.bseebix", "as;eofaorgmaproga " + LocalDateTime.now());

            System.out.println();
        };
        ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, 5, TimeUnit.SECONDS);
//        scheduler.schedule(() -> { beeperHandle.cancel(true); }, 60 * 60, TimeUnit.SECONDS);
    }
}
