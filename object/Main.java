package object;

public class Main {
    public static void main(String[] args) {
        Object o = new Object();
        paramCheck(1 == 1); // Works

        Dog dog = new Dog("dog");
        Cat cat = new Cat("cat");

        System.out.println("dog.name = " + dog.name);
        System.out.println("cat.name = " + cat.name);
    }

    public static void paramCheck(boolean isTrue) {

    }
}
