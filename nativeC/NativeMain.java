package nativeC;

public class NativeMain {
    public native int square(int i);
    public static void main(String[] args) {
        System.loadLibrary("Main");
        System.out.println(new NativeMain().square(2));
    }
}
