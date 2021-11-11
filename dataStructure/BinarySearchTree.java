package dataStructure;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class BinarySearchTree {

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private Node root;
    private int size;

//    private BinarySearchTree(int data) {
//        this.root = new Node(data);
//    }

    public void insert(int data) {
        add(data);
        size++;
    }

    private void add(int data) {
        var node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (data < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean contains(int data) {
        var current = root;
        while (current != null) {
            if (data < current.value) current = current.left;
            else if (data > current.value) current = current.right;
            else return true;
        }
        return false;
    }

    public void traversLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for(var item: getKthNodes(i)){
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    public List<Integer> getKthNodes(int distance) {
        var result = new ArrayList<Integer>();
        getKthNodes(root, distance, result);
        return result;
    }

    private void getKthNodes(Node node, int distance, List<Integer> list) {
        if (node == null) return;
        if (distance == 0) list.add(node.value);

        getKthNodes(node.left, distance - 1, list);
        getKthNodes(node.right, distance - 1, list);
    }

    //    BINARY SEARCH TREE
    public int min() {
        var current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int minVal() {
        return min(root);
    }

    //    BINARY TREE
    private int min(Node node) {
        if (isLeaf(node)) return node.value;

        var left = min(node.left);
        var right = min(node.right);

        return Math.min(Math.min(left, right), node.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        if (node.left == null && node.right == null) return 0;
        return 1 + max(height(node.left), height(node.right));
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    @Deprecated
    public void insert(int data, Node current) {
        if (current.value == data) return;

        if (current.value > data) {
            if (current.left != null) {
                insert(data, current.left);
            } else {
                current.left = new Node(data);
            }
        } else {
            if (current.right != null) {
                insert(data, current.right);
            } else {
                current.right = new Node(data);
            }
        }
    }

    @Deprecated
    public boolean find(int data, Node current) {
        if (current.value == data) return true;
        if (current == null) return false;
        if (current.value > data) {
            if (current.left != null) {
                insert(data, current.left);
            } else {
                current.left = new Node(data);
            }
        } else {
            if (current.right != null) {
                insert(data, current.right);
            } else {
                current.right = new Node(data);
            }
        }

        return false;
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return size;
    }
}
