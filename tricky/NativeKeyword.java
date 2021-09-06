package tricky;

public class NativeKeyword {
    /*
        JNI -> Java Native Interface
        The native keyword is applied to a method to indicate that
        the method is implemented in native code using JNI (Java Native Interface).
     */
    public native int square(int i);
    public static void main(String[] args) {
        System.loadLibrary("Main");
        System.out.println(new NativeKeyword().square(2));
    }
}
