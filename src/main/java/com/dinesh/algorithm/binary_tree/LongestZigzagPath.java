package com.dinesh.algorithm.binary_tree;

/**
 *
 */
public class LongestZigzagPath {
    public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;
        int left = longestZigZag(root, false, 0);
        int right = longestZigZag(root, true, 0);
        return Math.max(left, right)-1;
    }

    public int longestZigZag(TreeNode root, boolean flag, int count) {
        if(root == null)
            return count;
        int left = longestZigZag(root.left, false, flag ? count + 1 : 1);
        int right = longestZigZag(root.right, true, flag ? 1 : count + 1);

        return Math.max(left, right);
    }
}
