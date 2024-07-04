package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 *
 * https://www.youtube.com/watch?v=Bfqd8BsPVuw
 *
 */
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        return values;
    }
    private void traverse(TreeNode node, List<Integer> values) {
        if(node == null)
            return;
        values.add(node.val);
        traverse(node.left, values);
        traverse(node.right, values);
    }

    private void traverseIterative(TreeNode root, List<Integer> values) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            values.add(popped.val);
            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }

    }

}
