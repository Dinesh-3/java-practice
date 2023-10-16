package com.dinesh.datastructure.linkedlist;

import java.util.Arrays;

class DoublyLinkedList<T> {
    private class Node {
        private T value;
        private DoublyLinkedList.Node prev;
        private DoublyLinkedList.Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private DoublyLinkedList.Node first;
    private DoublyLinkedList.Node last;
    private int size;

    public void addLast(T value) {
        var node = new DoublyLinkedList.Node(value);
        if (first == null) first = last = node;
        else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        var node = new DoublyLinkedList.Node(value);
        if (first == null) first = last = node;
        else {
            first.prev = node;
            node.next = first;
            first = node;
        }
        size++;
    }

    public void removeFirst() {
        if (size == 0) return;
        first = first.next;
        first.prev = null;
        size--;
    }

    public void removeLast() {
        if (size == 0) return;
        last = last.prev;
        last.next = null;
        size--;
    }

    public void remove(T value) {
        if (first.value.equals(value)) {
            removeFirst();
            return;
        }
        if (last.value.equals(value)) {
            removeLast();
            return;
        }

        var current = first;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current == null) return;
        DoublyLinkedList.Node prev = current.prev;
        prev.next = current.next;
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        var current = first;
        int index = 0;
        while (current != null) {
            //array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public T[] toArrayInReverseOrder() {
        T[] array = (T[]) new Object[size];
        var current = last;
        int index = 0;
        while (current != null) {
            //array[index++] = current.value;
            current = current.prev;
        }
        return array;
    }

    public T get(int index) {
        if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException("Invalid index " + index);
        var current = first;
        int currentIndex = 0;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        return null; //current.value;
    }

    public int indexOf(T value) {
        var current = first;
        int currentIndex = 0;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
            currentIndex++;
        }
        return current == null ? -1 : currentIndex;
    }

}
