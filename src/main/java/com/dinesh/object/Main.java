package com.dinesh.object;

import model.User;
import utils.Console;

public class Main {
    public static void main(String[] args) {
        /**
         * Object class Contains methods -> equals, hashCOde, clone, toString, getClass, finalize, wait, notify, notifyAll
         */
        Object o = new Object();
        paramCheck(1 == 1); // Works
        int[] answer = new int[]{1,3,4,2}; // works
        passingArray(new int[]{1,3,4,2}); // Passing array

        Dog dog = new Dog("dog");
        Cat catOne = new Cat("cat");
        Cat catTwo = new Cat("cat");

        System.out.println("catOne == catTwo = " +  String.valueOf(catOne.equals(catTwo)));
        System.out.println("dog.name = " + dog.name);
        System.out.println("cat.name = " + catOne.name);

        User user1 = new User("Dinesh", "I", "2001-01-01");
        User user2 = new User("Dinesh", "I", "2001-02-01");
        boolean equals = user1.equals(user2);
        System.out.println(user1 == user2);
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();
        System.out.println("hashCode = " + hashCode1 + " " + hashCode2);
        System.out.println("equals = " + equals);
        Console.log("Dinesh", "I", 9, 8, 7);

    }

    public static void paramCheck(boolean isTrue) {

    }

    public static void passingArray(int[] numbers){

    }
}
