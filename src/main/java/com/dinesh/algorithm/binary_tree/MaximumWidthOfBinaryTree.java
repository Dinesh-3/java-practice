package com.dinesh.algorithm.binary_tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] tree = { 1,3,2,5,null,null,9,6,null,7 };
        TreeNode root = TreeNode.insertLevelOrder(tree);

        MaximumWidthOfBinaryTree binaryTree = new MaximumWidthOfBinaryTree();
        binaryTree.widthOfBinaryTree(root);
    }


    class Pair {
        int index;
        TreeNode node;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int maxWidth = 1;

        while(!queue.isEmpty()) {
            int length = queue.size();

            if(queue.size() > 1)
                maxWidth = Math.max(maxWidth, queue.getLast().index - queue.getFirst().index + 1);

            for(int i = 0; i < length; i++) {
                Pair pair = queue.remove();
                TreeNode node = pair.node;
                if(node.left != null)
                    queue.add(new Pair(node.left, 2 * (pair.index - 1) + 1));
                if(node.right != null)
                    queue.add(new Pair(node.right, 2 * (pair.index - 1) + 2));
            }

        }
        return maxWidth;

    }

}
