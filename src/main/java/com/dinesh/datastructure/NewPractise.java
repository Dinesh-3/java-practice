package datastructure;

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

class DineshMap<K,V> {
    private class Entity<K,V>{
        private K key;
        private V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private Entity[] table =  new Entity[16];

    public DineshMap() {
    }

    public DineshMap(int size) {
        this.table =  new Entity[size];
    }

    public void put(K key, V value) {
        int index = getIndex(key.hashCode());
        table[index] = new Entity(key, value);
    }

    public V get(K key){
        int index = getIndex(key.hashCode());
        return (V) table[index].value;
    }

    private int getIndex(int key) {
        if( key < 0) key = - key;
        return key % table.length;
    }

}

class BST {
    class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    private Node root;
    private int size;

    public BST(int data) {
        this.root = new Node(data);
    }

    public void insert(int data) {
        insert(root, data);
        size++;
    }

    public void insert(Node node,int data) {
        if(node.data < data) {
            if(node.right == null) {
                node.right = new Node(data);
            }else {
                insert(node.right, data);
            }
        }else {
            if(node.left == null) {
                node.left = new Node(data);
            }else {
                insert(node.left, data);
            }
        }
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node root, int target) {
        Node current = root;
        while (current != null) {
            if(current.data == target) return true;
            if(current.data < target) current = current.right;
            else current = current.left;
        }
        return false;

//        while (true) {
//            if(current == null) return false;
//            if(current.data == target) return true;
//            if(current.data < target) current = current.right;
//            else current = current.left;
//        }
    }

    public int heightOfRootNode() {
        return heightOfGivenNode(root);
    }

    private int heightOfGivenNode(Node node) {
        if(node == null) return -1;
        if(isLeafNode(node)) return 0;
        int left = heightOfGivenNode(node.left);
        int right = heightOfGivenNode(node.right);
        return 1 + Integer.max(left, right);
    }

    public List<Integer> inOrderTraversal() {
        return inOrderTraversal(root, new ArrayList<>());
    }
    private List<Integer> inOrderTraversal(Node node, List<Integer> list) {
        if(node == null) return null;
        inOrderTraversal(node.left, list);
//        System.out.println(node.data);
        list.add(node.data);
        inOrderTraversal(node.right, list);
        return list;
    }

    public List<List<Integer>> levelOrderTraversal() {
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= heightOfRootNode(); i++) {
            nodes.add(getKthNodes(i));
        }
        return nodes;
    }

//    public void levelOrderTraversalT() {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        levelOrderTraversalT(root, map);
//        System.out.println("map = " + map);
//    }
//
//    private void levelOrderTraversalT(Node current, Map<Integer, List<Integer>> map) {
//        if(current == null) return;
//        if(distance <= 0) {nodes.add(current.data); return;}
//        getKthNodes(current.left, distance - 1, nodes);
//        getKthNodes(current.right, distance - 1, nodes);
//    }

    public boolean equals(BST other) {
        if(other == null) return false;
        if(other == this) return true;
        return isEquals(root, other.root);
    }

    private boolean isEquals(Node current, Node other){
        if(current == null && other == null) return true;
        if(current != null && other != null) return
                current.data == other.data
                && isEquals(current.left, other.left)
                && isEquals(current.right, other.right);
        return false;
    }

    public boolean isValidBST(BST bst){
//        root.right.left.data = 56; // To test falsy
        return isValidBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(Node current, int min, int max){
        if(current == null ) return true;
        else return (current.data > min && current.data < max)
                    && isValidBST(current.left, min, current.data - 1)
                    && isValidBST(current.right, current.data + 1, max)
                    ;
//        if(current == null ) return true;
//        if(current.data < min || current.data > max) return false;
//        return isValidBST(current.left, min, current.data - 1)
//                && isValidBST(current.right, current.data + 1, max);
    }

    public int getKthNode(int distance){
        return getKthNode(root, distance).data;
    }

    private Node getKthNode(Node current, int distance){
        if(current == null) return null;
        if(distance <= 0) return current;
        Node found = getKthNode(current.left, distance - 1);
        if(found != null) return found;
        Node foundRight = getKthNode(current.right, distance - 1);
        if(foundRight != null) return foundRight;
        return null;
    }

    public List<Integer> getKthNodes(int distance) {
        List<Integer> list = new ArrayList<>();
        getKthNodes(root, distance, list);
        return list;
    }

    private void getKthNodes(Node current, int distance, List<Integer> nodes){
        if(current == null) return;
        if(distance <= 0) {nodes.add(current.data); return;}
        getKthNodes(current.left, distance - 1, nodes);
        getKthNodes(current.right, distance - 1, nodes);
    }

    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if(node == null) return Integer.MAX_VALUE;
        if(isLeafNode(node)) return node.data;
        int left = min(node.left);
        int right = min(node.right);
        return Math.min(Math.min(left, right), node.data);
    }

    public int max(){
        return max(root);
    }

    private int max(Node current) {
        if(current == null) return Integer.MIN_VALUE;
        int left = max(current.left);
        int right = min(current.right);
        return Math.max(current.data, Math.max(left, right));
    }

    public int countLeaves() {
        Node result = new Node(0);
        countLeaves(root, result);
        return result.data;
    }

    private void countLeaves(Node current, Node count) {
        if(current == null) return;
        if(isLeafNode(current)) count.data++;
        countLeaves(current.left, count);
        countLeaves(current.right, count);
        return;
    }

    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }


    private int minBST(Node node) { // For Binary Search Tree
        Node current = node;
        while (current.left != null) current = current.left;
        return current.data;
    }

    private int maxBST(Node node) { // For Binary Search Tree
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public int size() {
        return size;
    }
}

public class NewPractise {
    public static void main(String[] args) {
        /**
         *              30
         *           /     \
         *          20       40
         *           \     /    \
         *            25   35    42
         *                   \
         *                   36
         *
         */
        BST bst = new BST(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(25);
        bst.insert(35);
        bst.insert(42);
        bst.insert(36);

        List<Integer> integers = bst.inOrderTraversal();

        System.out.println("integers = " + integers);

        System.out.println("bst.size() = " + bst.size());
        System.out.println("bst.contains(35) = " + bst.contains(35));
        System.out.println("bst.heightOfGivenNode() = " + bst.heightOfRootNode());
        bst.min();
        System.out.println("bst.min() = " + bst.min());
        System.out.println("bst.max() = " + bst.max());
        boolean validBST = bst.isValidBST(bst);
        System.out.println("validBST = " + validBST);
        System.out.println("bst.getKthNode(2) = " + bst.getKthNode(3));
        System.out.println("bst.getKthNodes(2) = " + bst.getKthNodes(2));
        System.out.println("bst.levelOrderTraversal() = " + bst.levelOrderTraversal());
        System.out.println("bst.countLeaves() = " + bst.countLeaves());


        new Hashtable<>();
        DineshMap<Integer, String> dineshMap = new DineshMap<>();
        dineshMap.put(1, "Dinesh");
        String as = dineshMap.get(1);
        System.out.println("as = " + as);
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
