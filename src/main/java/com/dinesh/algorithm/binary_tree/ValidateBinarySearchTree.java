package com.dinesh.algorithm.binary_tree;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        return root.val >= min && root.val <= max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max );
    }

}
