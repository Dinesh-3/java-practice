package com.dinesh.algorithm.binary_tree;

import java.util.*;

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view
 *
 * https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
 *
 */
public class RightSideViewOfBinaryTree {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        rightSideView(root, rightView, 0);
        return rightView;
    }

    private void rightSideView(TreeNode root,List<Integer> visited, int level) {
        if(root == null)
            return;
        if(level == visited.size())
            visited.add(root.val);

        rightSideView(root.right, visited, level+1);
        rightSideView(root.left, visited, level+1);

    }

    public class Pair {
        int level;
        TreeNode node;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));


        Set<Integer> visitedLevels = new HashSet<>();

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();

            if(visitedLevels.size() == pair.level) {
                result.add(pair.node.val);
                visitedLevels.add(pair.level);
            }

            if(pair.node.right != null)
                queue.add(new Pair(pair.node.right, pair.level + 1));

            if(pair.node.left != null)
                queue.add(new Pair(pair.node.left, pair.level + 1));

        }

        return result;


    }

}
