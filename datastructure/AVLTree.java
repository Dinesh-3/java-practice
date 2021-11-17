package datastructure;

public class AVLTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    private Node root;

    public void insert(int data) {
        insert(data, root);
    }

    private void insert(int data, Node current) {
        if (current.value == data) return;

        if (current.value > data) {
            if (current.left != null) insert(data, current.left);
            else current.left = new Node(data);
        } else {
            if (current.right != null) insert(data, current.right);
            else current.right = new Node(data);
        }
    }
}
