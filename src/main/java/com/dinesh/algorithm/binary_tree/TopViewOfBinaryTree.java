package com.dinesh.algorithm.binary_tree;

import java.util.*;

import static com.dinesh.algorithm.binary_tree.TreeNode.insertLevelOrder;

/**
 * https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 */
public class TopViewOfBinaryTree {

    private static class TreeVertxNode {
        private Node node;
        private int vertx;

        public TreeVertxNode(Node node, int vertx) {
            this.node = node;
            this.vertx = vertx;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 10, null, null, 3, null, null, 6, 4, 9, null, 5};
        Node node = insertLevelOrder(nums, "node");
        ArrayList<Integer> result = topView(node);
        System.out.println("result = " + result);
    }

    static ArrayList<Integer> topView(Node root) {

        Queue<TreeVertxNode> result = new PriorityQueue<>(Comparator.comparing(a -> a.vertx));

        Queue<TreeVertxNode> queue = new LinkedList<>();
        queue.add(new TreeVertxNode(root, 0));

        Set<Integer> verticals = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeVertxNode removed = queue.remove();
                if(!verticals.contains(removed.vertx)) {
                    result.add(removed);
                    verticals.add(removed.vertx);
                }
                if(removed.node.left != null)
                    queue.add(new TreeVertxNode(removed.node.left, removed.vertx - 1));
                if(removed.node.right != null)
                    queue.add(new TreeVertxNode(removed.node.right, removed.vertx + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!result.isEmpty())
            ans.add(result.remove().node.data);

        return ans;

    }

}
