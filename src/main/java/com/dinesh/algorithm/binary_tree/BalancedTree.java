package com.dinesh.algorithm.binary_tree;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree
 *
 * https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/
 * https://www.youtube.com/watch?v=Yt50Jfbd8Po
 *
 */
public class BalancedTree {
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
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        int result = isBalanced(root, 0);
        if(result == -1)
            return false;
        return true;
    }

    private int isBalanced(TreeNode root, int val) {
        if(root == null)
            return 0;
        int leftHeight = isBalanced(root.left, val + 1);
        int rightHeight = isBalanced(root.right, val + 1);
        if(leftHeight == -1 || rightHeight == -1)
            return -1;
        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
