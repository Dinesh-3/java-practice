package com.dinesh.algorithm.leetcode75;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {
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

    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
