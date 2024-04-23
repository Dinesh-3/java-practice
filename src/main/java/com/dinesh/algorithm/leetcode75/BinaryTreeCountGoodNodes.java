package com.dinesh.algorithm.leetcode75;

/**
 * 1448. Count Good Nodes in Binary Tree
 */
public class BinaryTreeCountGoodNodes {
    public static class TreeNode {
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
    }
    public static void main(String[] args) {
        int[] numbers = {5,3,6,2,4,7};
        BinaryTreeCountGoodNodes binaryTree = new BinaryTreeCountGoodNodes();
        TreeNode bst = binaryTree.getBST(numbers);
        binaryTree.deleteNode(bst, 0);

    }

    private TreeNode getBST(int[] numbers) {
        TreeNode root = new TreeNode(numbers[0]);

        for (int i = 1; i < numbers.length; i++)
            insert(numbers[i], root);
        return root;
    }

    private static void insert(int val, TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if(val < current.val) {
                if(current.left == null)
                {
                    current.left = new TreeNode(val);
                    break;
                }
                else
                    current = current.left;
            } else {
                if(current.right == null)
                {
                    current.right = new TreeNode(val);
                    break;
                }
                else
                    current = current.right;
            }
        }
    }

    public int goodNodes() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int result = goodNodes(root,0);
        return result;
    }

    public int goodNodes(TreeNode current, int max) {
        if(current == null)
            return 0;
        int newMax = Math.max(max, current.val);
        int count = current.val >= max ? 1 : 0;
        count += goodNodes(current.left,newMax);
        count += goodNodes(current.right,newMax);
        return count;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        recursion(root, key);
        return root;
    }

    private TreeNode recursion(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key)
            return root;

        TreeNode left = recursion(root.left, key);
        TreeNode right = recursion(root.right, key);

        TreeNode node = left == null ? right : left;
        if(node != null) {
            root.left = node.left;
            TreeNode current = node.left;
            if(current != null) {
                while (current.right != null)
                    current = current.right;
                current.right = node.right;
            }
        }

        return null;
    }

}
