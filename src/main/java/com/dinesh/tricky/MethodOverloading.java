package com.dinesh.tricky;

import java.util.ArrayList;
import java.util.List;

public class MethodOverloading {
    public static void main(String[] args) {
        /**
         * Ambiguous method call. Both
         * get
         * (String)
         * in MethodOverloading and
         * get
         * (List<Integer>)
         * in MethodOverloading match
         */
//        get(null);

        ArrayList<Integer> list = new ArrayList<>();
        get(list);

        ArrayList<Object> objectArrayList = new ArrayList<>();
        get(objectArrayList); // calls get(Object o)
    }

    public static void get(String o){
        System.out.println("String");
    }
    public static void get(Object o){
        System.out.println("Object");
    }

    public static void get(List<Integer> o){
        System.out.println("List<Integer>");
    }


//    public static void main(String[] args) { // Throws Error
//
//    }
}
