package Interfaces;

import java.util.List;

/**
 * Diamond Problem:
 *  If two interfaces have same method signature diamond problem will occur
 *  (Interfaces.Utility inherits unrelated defaults for print(int) from types Interfaces.Utility1 and Interfaces.Utility2)
 *  Fix:
 *      To fix this issue we need override the method
 */

public class Utility implements Utility1, Utility2{
    @Override
    public void print(int a) {
        Utility1.super.print(a); // To resolve diamond problem
    }

    private String demo() {
        int totalMethods = Utility1.totalMethods;
        System.out.println("totalMethods = " + totalMethods);
        return "";

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
