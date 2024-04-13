package datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {


    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root;
    private int size;

    public void add(int value){
        addNode(new Node(value));
        ++size;
    }

    private void addNode(Node node){
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (node.value < current.value) {
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

    public boolean contains(int value) {
        Node current = root;

        while (current != null) {
            if(value == current.value)
                return true;
            if(value < current.value) {
                current = current.left;
            }else
                current = current.right;
        }

        return false;
    }

    public int[] preOrderTraversal(){
        Traversal traversal = new Traversal();

        return traversal.preOrder();
    }

    public int[] inOrderTraversal(){
        Traversal traversal = new Traversal();

        return traversal.inOrder();
    }

    public int[] postOrderTraversal(){
        Traversal traversal = new Traversal();

        return traversal.postOrder();
    }

    public int height(){
        return height(root);
    }
    // 1 + max(1+1)
    private int height(Node current) {
        if(current == null)
            return 0;
        return 1 + Math.max(Math.max(height(current.left), height(current.right)), current.value);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public int min(){
        return min(root);
    }

    public int min(Node current){
        if(current == null) return Integer.MAX_VALUE;

        if(isLeaf(current)) return current.value;

        int left = min(current.left);
        int right = min(current.right);

        return Math.min(Math.min(left, right), current.value);

    }

    public boolean equals(BinarySearchTree other) {
        if(other == null) return false;

        return equals(root, other.root);
    }
    private boolean equals(Node current, Node other) {
        if(current == null && other == null)
            return true;
        if(current != null && other != null)
            return current.value == other.value
                    && equals(current.left, other.left)
                    && equals(current.right, other.right);
        return false;
    }

    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBST(Node current, int min, int max){
        if(current == null) return true;

        return current.value > min && current.value < max &&
        isValidBST(current.left, min, current.value) &&
        isValidBST(current.right, current.value, max);
    }

        private List<Integer> getNodesAtDistance(Node node, int distance) {
            List<Integer> nodes = new ArrayList<>();
            findKthElement(node, distance, nodes);
            return nodes;
        }
    private int findKthElement(Node current, int distance) {
        if(current == null) return -1;
        if(distance == 0) return current.value;

        int resultOne = findKthElement(current.left, distance - 1);
        int resultTwo = findKthElement(current.left, distance - 1);

        if(resultOne > 0) return resultOne;
        if(resultTwo > 0) return resultTwo;
        return -1;
    }

    public List<Integer> findKthElement(int distance) {
        List<Integer> list = new ArrayList<>();
        findKthElement(root, distance, list);
        return list;
    }
    private void findKthElement(Node current, int distance, List<Integer> list) {
        if(current == null) return;
        if(distance == 0) list.add(current.value);

        findKthElement(current.left, distance - 1, list);
        findKthElement(current.right, distance - 1, list);
    }


    public int size() {
        return getSize(root);
    }

    private int getSize(Node current) {
        if (current == null)
            return 0;

        return 1 + getSize(current.left) + getSize(current.right);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node current) {
        if(current == null)
            return 0;
        if(isLeaf(current))
            return 1;
        return countLeaves(current.left) + countLeaves(current.right);
    }

    public boolean isPresent(int value) {
        return isPresent(root, value);
    }

    private boolean isPresent(Node current, int value) {
        if(current == null)
            return false;
        if(current.value == value)
            return true;
        boolean isPresentLeft = isPresent(current.left, value);
        boolean isPresentRight = isPresent(current.right, value);

        return isPresentLeft || isPresentRight;
    }

    public boolean areSiblings(int first, int second) {
        return areSiblings(root, first, second);
    }

    private boolean areSiblings(Node current, int first, int second) {
        if(current == null)
            return false;
        if(current.left != null && current.right != null && current.left.value == first && current.right.value == second)
            return true;
        return areSiblings(current.left, first, second) || areSiblings(current.right, first, second);
    }

    public List<Integer> getAncestors(int value) {
        List<Integer> ancestors = new ArrayList<>();
        getAncestors(root, value, ancestors);
        return ancestors;
    }

    private boolean getAncestors(Node current, int value, List<Integer> ancestors) {
        if(current == null)
            return false;
        if(current.value == value)
            return true;
        boolean leftVal = getAncestors(current.left, value, ancestors);
        boolean rightVal = getAncestors(current.right, value, ancestors);

        if(leftVal || rightVal) {
            ancestors.add(current.value);
            return true;
        }
        return false;
    }

    public boolean isBalanced() {
        isBalanced(root, 0);
        return true;
    }

    private int isBalanced(Node current, int height) {
        if(current == null)
            return 0;

        int left = isBalanced(current.left, height);
        if(left == -1)
            return -1;
        int right = isBalanced(current.right, height);
        if(right == -1)
            return -1;

        return 0;
    }

    class Traversal {

        private int index;
        private int[] numbers;

        public Traversal() {
            reset();
        }

        private void reset() {
            index = 0;
            numbers = new int[size];
        }

        public int[] inOrder(){
            reset();
            inOrder(root);
            return numbers;
        }
        private void inOrder(Node current){

//        if(numbers[size-1] != 0)
//            return numbers;

            if (current == null)
                return;

            inOrder(current.left);

            numbers[index++] = current.value;

            inOrder(current.right);

        }

        public int[] preOrder(){
            reset();
            preOrder(root);
            return numbers;
        }
        private void preOrder(Node current){

            if (current == null)
                    return;

            numbers[index++] = current.value;
            preOrder(current.left);
            preOrder(current.right);

        }

        public int[] postOrder(){
            reset();
            postOrder(root);
            return numbers;
        }
        private void postOrder(Node current){

            if (current == null)
                return;

            postOrder(current.left);
            postOrder(current.right);
            numbers[index++] = current.value;

        }

        public void traversLevelOrder() {
            for (int i = 0; i < height(root); i++) {
                List<Integer> nodes = getNodesAtDistance(root, i);
                System.out.println("nodes = " + nodes);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(inOrderTraversal());
    }
}
