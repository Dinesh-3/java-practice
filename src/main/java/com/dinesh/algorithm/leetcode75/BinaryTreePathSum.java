package com.dinesh.algorithm.leetcode75;

/**
 * 437. Path Sum III
 */
public class BinaryTreePathSum {

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

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return getSubPathSum(root.left, targetSum) + getSubPathSum(root, targetSum) + getSubPathSum(root.right, targetSum);
    }

    public int getSubPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        int res = 0;
        if(root.val == targetSum) res++;
        res += getSubPathSum(root.left, targetSum - root.val);
        res += getSubPathSum(root.right, targetSum - root.val);
        return res;
    }


}
