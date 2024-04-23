package com.dinesh.algorithm.leetcode75;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 */
public class BinaryTreeMaximumLevelSum {
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

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int height = height(root);

        for (int i = 1; i <= height; i++) {
            int sum = getLevelSum(root, i, 0);
            if(maxSum < sum)
                level = i + 1;
            maxSum = Math.max(sum, maxSum);

        }

        return level;

    }

    private int getLevelSum(TreeNode node, int height, int current) {
        if(node == null)
            return 0;
        if(current == height)
            return node.val;

        int leftSum = getLevelSum(node.left, height, current + 1);
        int rightSum = getLevelSum(node.right, height, current + 1);

        return leftSum + rightSum;
    }

    private int height(TreeNode node) {
        if(node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

}
