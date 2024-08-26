package com.dinesh.algorithm.binary_search_tree;

/**
 *
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
 *
 * https://www.youtube.com/watch?v=UmJT3j26t1I
 *
 *
 */
public class ConstructBSTFromPreOrderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = { 0 };
        return dfs(index, preorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] index, int[] preorder, int max) {
        int i = index[0];
        if(i == preorder.length || preorder[i] > max)
            return null;

        TreeNode node = new TreeNode(preorder[i]);
        index[0] += 1;

        node.left = dfs(index, preorder, node.val);
        node.right = dfs(index, preorder, max);

        return node;
    }
}
