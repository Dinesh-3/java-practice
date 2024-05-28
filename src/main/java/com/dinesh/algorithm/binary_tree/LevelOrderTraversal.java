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

    public void levelOrderTraversal(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.remove();
                if(pop == null)
                    break;
                level.add(pop.val);
                if(pop.left != null)
                    queue.add(pop.left);
                if(pop.right != null)
                    queue.add(pop.right);
            }
            if(!level.isEmpty())
                list.add(level);
        }

        System.out.println("list = " + list);
    }

}
