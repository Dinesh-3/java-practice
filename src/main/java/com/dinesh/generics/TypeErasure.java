package com.dinesh.generics;

/**
 * Java replaces all the Generic Type to Object at compile time is known as Type Eraser
 * Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic programming. To implement generics, the Java compiler applies type erasure to:
 *
 * Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
 * Insert type casts if necessary to preserve type safety.
 * Generate bridge methods to preserve polymorphism in extended generic types.
 * Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.
 */
public class TypeErasure {

    public class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() { return data; }
        // ...
    }

    /*
    public class Node {

        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() { return data; }
        // ...
    }
     */

}

