package com.dinesh.tricky;

public class ExceptionPractice {
    public static void main(String[] args) {
        try {
            int[] arr = new int[10];
            System.out.println("arr[11] = " + arr[11]);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        /**
         * Throws compile time error
         */
//        catch (ArrayIndexOutOfBoundsException e) { // Exception 'java.lang.ArrayIndexOutOfBoundsException' has already been caught
//            System.out.println("e = " + e);
//        }
    }
}
