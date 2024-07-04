package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        TreeNode tree = new TreeNode();
        traversal.levelOrderTraversal(tree);
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                TreeNode node = queue.remove();

                level.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
