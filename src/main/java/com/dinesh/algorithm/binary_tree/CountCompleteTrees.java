package com.dinesh.algorithm.binary_tree;

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes
 *
 * https://www.youtube.com/watch?v=u-yWemKGWO0
 *
 */
public class CountCompleteTrees {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);

        if(leftHeight == rightHeight)
            return (2 << leftHeight) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private int getLeftHeight(TreeNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    private int getRightHeight(TreeNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.right;
        }
        return count;
    }
}
