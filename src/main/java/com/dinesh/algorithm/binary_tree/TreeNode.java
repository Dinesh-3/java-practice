package com.dinesh.algorithm.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode insertLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode currentNode = queue.poll();

            // Insert left child
            if (i < arr.length && arr[i] != null) {
                currentNode.left = new TreeNode(arr[i]);
                queue.add(currentNode.left);
            }
            i++;

            // Insert right child
            if (i < arr.length && arr[i] != null) {
                currentNode.right = new TreeNode(arr[i]);
                queue.add(currentNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node insertLevelOrder(Integer[] arr, String type) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node currentNode = queue.poll();

            // Insert left child
            if (i < arr.length && arr[i] != null) {
                currentNode.left = new Node(arr[i]);
                queue.add(currentNode.left);
            }
            i++;

            // Insert right child
            if (i < arr.length && arr[i] != null) {
                currentNode.right = new Node(arr[i]);
                queue.add(currentNode.right);
            }
            i++;
        }

        return root;
    }

}
