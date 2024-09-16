package com.dinesh.algorithm.binary_tree;

import java.util.*;

/**
 *
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * https://takeuforward.org/data-structure/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://www.youtube.com/watch?v=LgLRTaEMRVc
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        var construct = new ConstructBinaryTreeFromInorderAndPostorder();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        construct.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
            map.put(inorder[i], i);

        return build(0, n-1, 0, n-1, map, inorder, postorder);
    }

    private TreeNode build(int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map, int[] inorder, int[] postorder) {
        if(inStart > inEnd || postStart > postEnd)
            return null;

        int root = postorder[postEnd];
        TreeNode node = new TreeNode(root);

        int leftNodes = map.get(root) - inStart;

        node.left = build(inStart, map.get(root) - 1, postStart, postStart + leftNodes - 1, map, inorder, postorder);
        node.right = build(map.get(root) + 1, inEnd, postStart + leftNodes, postEnd-1, map, inorder, postorder);
        return node;
    }

}
