package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;

/**
 *
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Height of a Binary Tree
 * https://www.youtube.com/watch?v=eD3tmO66aBA
 *
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
