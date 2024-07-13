package com.dinesh.tricky;

import java.lang.reflect.Method;

public class NativeKeyword {
    /*
        JNI -> Java Native Interface
        The native keyword is applied to a method to indicate that
        the method is implemented in native code using JNI (Java Native Interface).
     */
    public native int square(int i);
    public static void main(String[] args) {
//        System.loadLibrary("D:\\practice\\JavaPractice\\src\\main\\java\\com\\dinesh\\tricky\\Main.c");
        System.out.println(new NativeKeyword().square(2));

    }
}
