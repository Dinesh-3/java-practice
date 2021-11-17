package object;

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
        Cat cat = new Cat("cat");

        System.out.println("dog.name = " + dog.name);
        System.out.println("cat.name = " + cat.name);
    }

    public static void paramCheck(boolean isTrue) {

    }

    public static void passingArray(int[] numbers){

    }
}
