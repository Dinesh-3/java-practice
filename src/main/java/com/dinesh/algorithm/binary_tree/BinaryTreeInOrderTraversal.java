package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *  https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 *  https://www.youtube.com/watch?v=lxTGsVXjwvM
 *
 */
public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty())
                    break;
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        return list;

    }
}
