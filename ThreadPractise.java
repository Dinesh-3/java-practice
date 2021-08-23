public class ThreadPractise {
    public static void main(){
        System.out.println("Active Threads: " + Thread.activeCount());
        System.out.println("Total Threads in current system: " + Runtime.getRuntime().availableProcessors());
    }
}
