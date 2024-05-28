package com.dinesh.algorithm.binary_tree;

/**
 *  124. Binary Tree Maximum Path Sum
 *  https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 *  https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
 *  https://www.youtube.com/watch?v=WszrfSwMz58
 *
 */
public class BinaryTreeMaximumPathSum {
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

    public int maxPathSum(TreeNode root) {
        TreeNode current = new TreeNode();
        current.val = Integer.MIN_VALUE;
        maxPathSum(root, current);
        return current.val;
    }

    public int maxPathSum(TreeNode root, TreeNode maxSum) {
        if(root == null)
            return 0;

        int leftSum = Math.max(0, maxPathSum(root.left, maxSum));
        int rightSum = Math.max(0, maxPathSum(root.right, maxSum));
        maxSum.val = Math.max(leftSum + rightSum + root.val, maxSum.val);
        return root.val + Math.max(leftSum, rightSum);
    }

}


