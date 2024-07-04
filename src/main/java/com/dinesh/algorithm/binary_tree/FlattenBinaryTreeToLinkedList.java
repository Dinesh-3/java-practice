package com.dinesh.algorithm.binary_tree;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 *
 * https://www.youtube.com/watch?v=sWf7k1x9XR4
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode[] prev = { null };

        flatten(root, prev);

    }

    private void flatten(TreeNode root, TreeNode[] prev) {
        if(root == null)
            return;
        flatten(root.right, prev);
        flatten(root.left, prev);

        root.right = prev[0];
        prev[0] = root;
        root.left = null;
    }

    public void flattenUsingStack(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
            if(!stack.isEmpty())
                node.right = stack.peek();
            node.left = null;
        }

    }
}
