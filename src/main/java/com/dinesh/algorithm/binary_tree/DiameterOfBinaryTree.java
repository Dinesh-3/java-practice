package com.dinesh.algorithm.binary_tree;

public class DiameterOfBinaryTree {

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
    }

    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode max = new TreeNode(0);
        diameterOfBinaryTree(root, max);
        return max.val;
    }

    public int diameterOfBinaryTree(TreeNode node, TreeNode count) {
        if(node == null)
            return 0;

        int left = diameterOfBinaryTree(node.left, count);
        int right = diameterOfBinaryTree(node.right, count);
        count.val = Math.max(count.val, left + right);
        return 1 + Math.max(left, right);
    }
}
