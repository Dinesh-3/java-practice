package com.dinesh.algorithm.binary_search_tree;

import java.util.Stack;

/**
 *
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator
 *
 * https://www.youtube.com/watch?v=D2jMcmxU4bs
 *
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        push(root);
    }

    public int next() {
        TreeNode last = stack.pop();

        if(last.right != null)
            push(last.right);

        return last.val;
    }

    private void push(TreeNode current) {
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
