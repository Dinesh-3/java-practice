package com.dinesh.algorithm.binary_tree;

import java.util.*;

/**
 *
 * https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/
 * https://www.youtube.com/watch?v=aZNaLrVebKQ
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class ConstructBinaryTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> nodes = new HashMap<>();
        for(int i = 0; i < n; i++)
            nodes.put(inorder[i], i);
        return build(0, n-1, 0, n-1, nodes, preorder, inorder);
    }

    private TreeNode build(int inStart, int intEnd, int preStart, int preEnd, Map<Integer, Integer> nodes, int[] preorder, int[] inorder) {
        if(inStart > intEnd || preStart > preEnd)
            return null;

        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);

        int rootIndex = nodes.get(val);

        int numsLeft = rootIndex - inStart;

        node.left = build(inStart, rootIndex - 1, preStart + 1, preStart + numsLeft, nodes, preorder, inorder);
        node.right = build(rootIndex + 1, intEnd, preStart + numsLeft + 1, preEnd, nodes, preorder, inorder);

        return node;
    }

}
