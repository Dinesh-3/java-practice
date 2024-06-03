package com.dinesh.algorithm.binary_tree;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key)
            return helper(root);

        TreeNode current = root;
        while(current != null) {
            if(current.left != null && current.left.val == key) {
                current.left = helper(current.left);
                break;
            }
            if(current.right != null && current.right.val == key) {
                current.right = helper(current.right);
                break;
            }

            if(current.val < key)
                current = current.right;
            else
                current = current.left;
        }

        return root;

    }

    private TreeNode helper(TreeNode node) {
        if(node.left == null)
            return node.right;
        if(node.right == null)
            return node.left;

        TreeNode current = node.right;

        while (current.left != null)
            current = current.left;

        current.left = node.left;

        return node.right;
    }
}
