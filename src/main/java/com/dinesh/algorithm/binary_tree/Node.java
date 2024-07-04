package com.dinesh.algorithm.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }

    public static Node buildTree(String input) {
        if (input == null || input.length() == 0) return null;

        String[] values = input.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            Node currentNode = queue.poll();

            if (!values[i].equals("N")) {
                currentNode.left = new Node(Integer.parseInt(values[i]));
                queue.add(currentNode.left);
            }
            i++;

            if (i < values.length && !values[i].equals("N")) {
                currentNode.right = new Node(Integer.parseInt(values[i]));
                queue.add(currentNode.right);
            }
            i++;
        }

        return root;
    }

    public static void printTree(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

}