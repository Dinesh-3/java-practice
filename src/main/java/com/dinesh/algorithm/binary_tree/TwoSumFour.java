package com.dinesh.algorithm.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst
 *
 * https://www.youtube.com/watch?v=ssL3sHwPeb4
 *
 */
public class TwoSumFour {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return false;
        Map<Integer, TreeNode> map = new HashMap<>();
        setTarget(root, k, map);
        return findTarget(root, k, map);
    }

    public void setTarget(TreeNode root, int k, Map<Integer, TreeNode> map) {
        if(root == null)
            return;
        map.put(k - root.val, root);
        setTarget(root.left, k, map);
        setTarget(root.right, k, map);
    }

    public boolean findTarget(TreeNode root, int k, Map<Integer, TreeNode> map) {
        if(root == null)
            return false;
        if(map.containsKey(root.val) && map.get(root.val) != root)
            return true;
        return findTarget(root.left, k, map) || findTarget(root.right, k, map);
    }

}
