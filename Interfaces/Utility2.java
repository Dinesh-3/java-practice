package Interfaces;

public interface Utility2 {
    default void print(int a) {
        System.out.println(a);
    }
    int getName();
}
