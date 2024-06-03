package com.dinesh.algorithm.binary_tree;

public class BinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode current = root;

        while (current != null) {
            if(val > current.val) {
                if(current.right == null)
                    current.right = new TreeNode(val);
                else
                    current = current.right;
            } else {
                if(current.left == null)
                    current.left = new TreeNode(val);
                else
                    current = current.left;
            }
        }

        return root;
    }

}
