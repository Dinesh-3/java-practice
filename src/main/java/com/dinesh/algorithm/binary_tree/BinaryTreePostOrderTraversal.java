package com.dinesh.algorithm.binary_tree;

import java.util.*;
/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 */
public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(root);

        Stack<TreeNode> stack2 = new Stack<>();

        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }

        while(!stack2.isEmpty())
            list.add(stack2.pop().val);


        return list;
    }

}
