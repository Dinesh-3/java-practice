package collections;

import exception.UserException;
import model.User;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Implementations
 * 1. ArrayList
 * 2. LinkedList
 * 3. Vector
 * 4. Stack
 */
public class ListPractise {
    public static void main(String[] args) {
        /**
         * Return ImmutableCollections
         * We can't do insert, update or delete
         */
        List<String> ALPHABET = List.of("A", "B", "C", "D");
//        boolean add = ALPHABET.add("E"); // Throws UnsupportedOperationException
//        System.out.println("add = " + add);
        System.out.println("ALPHABET.getClass() = " + ALPHABET.getClass());

        /**
         * Initial Capacity 10
         * If array is full size will increase by 50 %
         * Not Synchronized
         */
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
//        numbers.clear();
        Object num = 3;
        numbers.remove(num);
        numbers.sort(comparing(a -> a));
        numbers.remove(num);
        System.out.println("numbers = " + numbers);
        /**
         *          LinkedList
         * public class LinkedList<E> extends AbstractSequentialList<E>
         * implements List<E>, Deque<E>, Cloneable, java.io.Serializable
         *
         * Doubly LinkedList Implementation
         *
         */

        LinkedList<Integer> linkedList = new LinkedList<>(); // Also implements Dequeue and Queue Interface
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.addFirst(5);
        linkedList.addLast(6);
        linkedList.sort(Comparator.reverseOrder());
        linkedList.element(); // returns first element in LinkedList
        System.out.println("linkedList = " + linkedList);
        /**
         *  Vector
         *  Points:
         *      1. Legacy Class
         *      2. Thread safe
         *
         *  1. Synchronized
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

        Stack<String> hackAnimal = new Stack<>();
        hackAnimal.push("dog");
        hackAnimal.push("bat");
        hackAnimal.push("cow");
        hackAnimal.push("rat");
        hackAnimal.push("cat");

        for(var item: hackAnimal){
            System.out.println(item);
        }
        hackAnimal.pop();
        hackAnimal.peek();
        hackAnimal.pop();

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
        list.remove("Dinesh");

        var index = list.indexOf("a");
        var lastIndex = list.lastIndexOf("a");
        System.out.println("list.subList(0, 2) = " + list.subList(0, 2));
        System.out.println(list);
//    list.replaceAll(item -> {if(item.equals("a")) return "d"; return item;});
        list.replaceAll(item -> item.equals("a") ? "FOUND" : item);
        System.out.println(list);
    }

    private void  rawList(){
        List list = new ArrayList<>();
        list.add("Dinesh");
        list.add(1);
        list.add(0.1F);
        list.add(true);
        try {
            list.add(new User("Dinesh", "I", "2001-06-01"));
        } catch (UserException e) {
            e.printStackTrace();
        }
        for(var item: list) {
            if(item instanceof String) System.out.println("String " + item);
            if(item instanceof User) System.out.println("User " + ((User) item).getFirstName());
            System.out.println("item = " + item.getClass());
        }
    }
}
