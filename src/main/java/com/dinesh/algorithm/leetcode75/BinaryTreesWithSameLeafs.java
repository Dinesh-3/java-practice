package com.dinesh.algorithm.leetcode75;
import java.util.*;

/**
 *
 872. Leaf-Similar Trees
 */
public class BinaryTreesWithSameLeafs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rootOneLeafs = getLeafs(root1);
        List<Integer> rootTwoLeafs = getLeafs(root2);

        if(rootOneLeafs.size() != rootTwoLeafs.size())
            return false;

        for(int i = 0; i < rootOneLeafs.size(); i++)
            if(!Objects.equals(rootOneLeafs.get(i), rootTwoLeafs.get(i)))
                return false;
        return true;
    }

    public List<Integer> getLeafs(TreeNode root) {
        List<Integer> leafs = new ArrayList<>();
        setLeafs(root, leafs);
        return leafs;
    }

    public void setLeafs(TreeNode root, List<Integer> leafs) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            leafs.add(root.val);

        setLeafs(root.left, leafs);
        setLeafs(root.right, leafs);
    }
}
