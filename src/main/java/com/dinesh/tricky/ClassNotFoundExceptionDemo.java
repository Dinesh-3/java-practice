package com.dinesh.tricky;

import java.lang.reflect.InvocationTargetException;

public class ClassNotFoundExceptionDemo {
    public static void main(String[] args) {
        try {

            try {
                Class.forName("com.dinesh.object.Employee")
                        .getConstructors()[0].newInstance("adasda");
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        /**
         * NoClassDefFoundError
         * Class not found at runtime -> .class filename is modified and deleted
         *
         * It's an error
         *
         */
    }
}
