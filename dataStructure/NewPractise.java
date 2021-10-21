package dataStructure;

import java.util.*;
import java.util.LinkedList;

class LinkedList2<T>{




    private class Node{

        private T data;
        private Node next;
        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
    private Node first;

    private Node last;
    private int size;

    public void add(int index, T data) {
        validateIndex(index);
        Node node = new Node(data);
        if(index == 0) addFirst(data);
        else if(index == size) addLast(data);
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
        size++;
        System.out.println("current = " + current);
    }

    private void validateIndex(int index) {
        if(index > size - 1 || index < 0) throw new IllegalArgumentException(String.format("Index %d, Size %d", index, size));
    }

    private Node getNode(int index) {
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            if(i == index) return x;
            i++;
        }
        throw new IllegalArgumentException("Index");
    }
    private Node getNode(T data) {
        Node current = first;

        while (current != null){
            if(current.data.equals(data)) return current;
            current = current.next;
        }
        throw new NoSuchElementException("Element " + data + " Not Found!");
    }
    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current.next != node) {
            current = current.next;
        }
        return current;
    }

    public void addFirst(T data) {
        Node node = new Node(data);
        if(first == null) {
            first = last = node;
            size++;
            return;
        }
        node.next = first;
        first = node;
        size++;
    }

    public void addLast(T data) {
        Node node = new Node(data);
        if(first == null) {
            first = last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public void removeFirst() {
        first = first.next;
        size--;
    }
    public void removeLast() {
        Node prev = getPreviousNode(last);
        prev.next = null;
        last = prev;
        size--;
    }
    public void remove(T data) {
        if(first.data.equals(data)) removeFirst();
        else if(last.data.equals(data)) removeLast();
        else {
            removeNode(getNode(data));
        }
        size--;
    }

    private void removeNode(Node node) {
        Node prev = getPreviousNode(node);
        prev.next = node.next;
    }

    public void remove(int index) {
        validateIndex(index);
        if(index == 0) removeFirst();
        else if(index == size - 1 ) removeLast();
        else {
            Node node = getNode(index);
            removeNode(node);
        }
    }
    public int size(){
        return size;
    }

    public List<T> toArray() {
        List<T> array = new ArrayList<>();
        Node current = first;
        while (current != null) {
            T data = current.data;
            array.add(data);
            current = current.next;
        }
        return array;
    }

}

public class NewPractise {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.toArray();
//        list.remove(10);

        LinkedList2<String> linkedList = new LinkedList2<>();
        linkedList.addFirst("Dinesh");
        linkedList.addFirst("Babu");
        linkedList.addLast("AddedAtLast");
        linkedList.add(1, "Hello At 1");
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        linkedList.remove("Dinesh");
//        linkedList.remove("Babu");
        linkedList.remove(6);
        List<String> strings = linkedList.toArray();
        System.out.println("strings = " + strings);

    }
}
