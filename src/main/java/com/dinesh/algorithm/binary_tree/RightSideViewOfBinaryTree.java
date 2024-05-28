package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view
 *
 * https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
 *
 */
public class RightSideViewOfBinaryTree {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        rightSideView(root, rightView, 0);
        return rightView;
    }

    private void rightSideView(TreeNode root,List<Integer> visited, int level) {
        if(root == null)
            return;
        if(level == visited.size())
            visited.add(root.val);

        rightSideView(root.right, visited, level+1);
        rightSideView(root.left, visited, level+1);

    }

}
