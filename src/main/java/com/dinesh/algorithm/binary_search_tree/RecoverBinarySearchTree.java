package com.dinesh.algorithm.binary_search_tree;

/**
 *
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * https://www.youtube.com/watch?v=ZWGW7FminDM
 *
 */
public class RecoverBinarySearchTree {
    class Data {
        TreeNode first;
        TreeNode middle;
        TreeNode second;

        TreeNode prev;
    }

    public void recoverTree(TreeNode root) {
        Data data = new Data();
        dfs(root, data);

        if(data.second == null) {
            TreeNode first = data.first;
            TreeNode middle = data.middle;

            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }

    }

    private void dfs(TreeNode root, Data data) {
        if(root == null)
            return;

        if(data.first != null && data.second != null)
            return;

        dfs(root.left, data);
        if(data.prev != null) {
            if(data.prev.val > root.val) {
                if(data.first == null) {
                    data.first = data.prev;
                    data.middle = root;
                } else {
                    data.second = root;

                    int temp = root.val;
                    root.val = data.first.val;
                    data.first.val = temp;
                }
            }
        }
        data.prev = root;
        dfs(root.right, data);

    }
}
