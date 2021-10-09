package Interfaces;

public interface Utility2 {
    public static String interfaceName = Utility2.class.getSimpleName();
    default void print(int a) {
        System.out.println(a);
    }
    int getName();
}
