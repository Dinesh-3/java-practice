package collections;

import java.util.*;

import static java.util.Comparator.comparing;

public class ListPractise {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(); // Initial Capacity 10
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.sort(comparing(a -> a));


        /**
         *          LinkedList
         * Doubly LinkedList Implementation
         */

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        /**
         *  Vector
         *  Points:
         *      1. Legacy Class
         *      2. Thread safe
         */

        Vector<Integer> integers = new Vector<>();

        integers.add(0);
        integers.add(1);
        integers.add(4);
        integers.add(2);
        integers.add(3);
        integers.sort(comparing(a -> a));
        System.out.println("integers = " + integers);

        /**
         * Stack
         * Last in First Out
         *  public class Stack<E> extends Vector<E>
         * methods:
         *  pop() -> Returns last element and remove
         *  peek() -> Returns last element
         *  empty() -> Returns Boolean stack is empty or not
         *  contains(T item) -> Returns boolean item exist or not
         */

        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
//        integerStack.pop();
//        integerStack.empty();
//        integerStack.peek();

        System.out.println("integerStack.peek() = " + integerStack.peek());
        System.out.println("integerStack = " + integerStack);
        System.out.println("integerStack.pop() = " + integerStack.pop());
        System.out.println("integerStack = " + integerStack);
        System.out.println("integerStack.contains(1) = " + integerStack.contains(1));
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // Add an item at a given index
        list.add(0, "!");

        // We can add multiple items in one go
        Collections.addAll(list, "a", "b", "c");

        var first = list.get(0);
        list.set(0, "!!");

        list.remove(0);

        var index = list.indexOf("a");
        var lastIndex = list.lastIndexOf("a");
        var subList = list.subList(0, 2);
        System.out.println(list);
//    list.replaceAll(item -> {if(item.equals("a")) return "d"; return item;});
        list.replaceAll(item -> item.equals("a") ? "FOUND" : item);
        System.out.println(list);
    }
}
