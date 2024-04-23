package com.dinesh.algorithm.leetcode75;

import datastructure.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeRightSideView {
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
        List<Integer> values = new ArrayList<>();
        int height = height(root);
        for (int i = 0; i <= height; i++) {
            TreeNode node  = getNodeAtLevel(root, i);
            values.add(node.val);
        }
        return values;
    }

    private TreeNode getNodeAtLevel(TreeNode root, int i) {
        Stack<TreeNode> nodes = new Stack<>();
        getNodeAtLevel(root, i, nodes, 0);
        return nodes.pop();
    }

    private void getNodeAtLevel(TreeNode node, int height, Stack<TreeNode> stack, int current) {

        if (node == null)
            return;

        if(height == current) {
            stack.add(node);
            return;
        }
        getNodeAtLevel(node.left, height, stack, current + 1 );
        getNodeAtLevel(node.right, height, stack, current + 1 );
    }

    private int height(TreeNode current) {
        if(current == null)
            return -1;
        return 1 + Math.max(height(current.left), height(current.right));
    }

    private void rightSideView(TreeNode current, List<Integer> values) {
        if(current == null)
            return;
        values.add(current.val);

        if(current.right != null)
            rightSideView(current.right, values);
        else
            rightSideView(current.left, values);
    }
}
