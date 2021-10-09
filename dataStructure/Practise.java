package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class LinkedList1<T>  {

    private class Node {
        private T data;
        private Node next;
        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(T data) {
        addLast(data);
    }

    public void addFirst(T data){
        Node node = new Node(data);
        if (isEmpty()) {
            handleEmpty(node);
            return;
        };
        node.next = first;
        first = node;
        size++;
    }
    public void addLast(T data){
        Node node = new Node(data);
        if (isEmpty()) {
            handleEmpty(node);
            return;
        }
        last.next = node;
        last = node;
        size++;
    }
    public void insertAt(int index, T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            handleEmpty(node);
            return;
        }
        if(!isValidIndex(index)) throw new IllegalArgumentException(index + " Is Not a valid index");

        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size - 1) {
            addLast(data);
            return;
        }

        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
//        System.out.println("current = " + current);
        node.next = current.next;
        current.next = node;
        size++;
    }

    public void removeFirst() {
        first = first.next;
        size--;
    }
    public void removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
            size--;
            return;
        }
        last = getPreviousNode(last);
        last.next = null;
        size--;
    }
    public void remove(T data) {
        if(isEmpty()) throw new NoSuchElementException();
        removeNode(getNode(data));
    }
    public void remove(int index) {
        if(isEmpty()) throw new NoSuchElementException();
        if(!isValidIndex(index)) throw new IllegalArgumentException("Invalid Index " + index);
        removeNode(getNode(index));
    }

    private void removeNode(Node node) {
        if(first == last) {
            first = last = null;
            size--;
            return;
        }
        Node prevNode = getPreviousNode(node);
        prevNode.next = node.next;
        size--;
    }

    private Node getNode(T data) {
        Node current = first;

        while (current != null){
            if(current.data.equals(data)) return current;
            current = current.next;
        }
        throw new NoSuchElementException("Element " + data + " Not Found!");
    }

    private Node getNode(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current.next != node) {
            current = current.next;
        }
        return current;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    private void handleEmpty(Node node) {
        first = node;
        last = node;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public List<T> toList(){
        List<T> list = new ArrayList<>();

        Node current = first;

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    @Override
    public String toString() {
        return toList().toString();
    }
}

class BinaryTree {


    private class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node tree;

    public void add(int data){
        if(tree == null) {
            tree = new Node(data);;
            return;
        }
        add(data, tree);
    }

    public void add(int data, Node currentNode){

        if(data < currentNode.data) {
            if(currentNode.left == null) {
                currentNode.left = new Node(data);;
            }else {
                add(data, currentNode.left);
            }
        }else {
            if(currentNode.right == null) {
                currentNode.right = new Node(data);;
            }else {
                add(data, currentNode.right);
            }
        }

    }
    public void preOrderTraversal() {
        preOrderTraversal(tree);
        System.out.println();
    }
    public void inOrderTraversal() {
        inOrderTraversal(tree);
        System.out.println();

    }
    public void postOrderTraversal() {
        postOrderTraversal(tree);
        System.out.println();
    }
    private void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public List<Integer> toList() {
        return inOrderTraversalList(tree, new ArrayList<>());
    }

    private List<Integer> inOrderTraversalList(Node node, List<Integer> list) {
        if (node == null) return null;
        inOrderTraversalList(node.left,list);
        list.add(node.data);
        inOrderTraversalList(node.right,list);
        return list;
    }

}

public class Practise {
    public static void main(String[] args) {
        linkedListPractise();
//        binaryTreePractise();
    }

    private static void binaryTreePractise() {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(6);
        tree.add(4);
        /**
         *              5
         *           /     \
         *          3       8
         *         / \     /
         *        2   4   6
         *
         */
        tree.preOrderTraversal(); // 5 3 2 4 8 6
        tree.inOrderTraversal(); // 2 3 4 5 6 8
        tree.postOrderTraversal(); // 2 4 3 6 8 5

        List<Integer> list = tree.toList();
        System.out.println("list = " + list);
    }

    private static void linkedListPractise() {
        LinkedList1<String> linkedList = new LinkedList1<>();
        linkedList.add("Dinesh");
        linkedList.addFirst("Babu");
        linkedList.addFirst("Ranjith");
        linkedList.addLast("New");
        linkedList.addLast("New2");
        System.out.println("linkedList = " + linkedList);
        linkedList.insertAt(3, "2Added");
        System.out.println("After inserted At Index 3 = " + linkedList);
//        linkedList.removeFirst();
        linkedList.removeLast();

//        linkedList.removeLast();
//        linkedList.remove("New2");
        linkedList.remove(1);
        List<String> stringList = linkedList.toList();
//        System.out.println("stringList = " + stringList);
        System.out.println("linkedList.size() = " + linkedList.size());
        System.out.println("linkedList = " + linkedList);
    }
}
