package com.dinesh.algorithm.binary_tree;

import com.google.common.collect.ForwardingSortedMultiset;
import com.google.common.collect.SortedMultiset;

import java.util.*;

import static com.dinesh.algorithm.binary_tree.TreeNode.insertLevelOrder;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree
 *
 * Vertical Order Traversal of Binary Tree
 * https://takeuforward.org/data-structure/vertical-order-traversal-of-binary-tree/
 *
 *  https://www.youtube.com/watch?v=q_a6lpbKJdw
 */
public class VerticalOrderTraversalBinaryTree {

    private class Node {
        TreeNode node = null;
        int verticalIndex, levelIndex;

        public Node(TreeNode node, int verticalIndex, int levelIndex) {
            this.node = node;
            this.verticalIndex = verticalIndex;
            this.levelIndex = levelIndex;
        }

    }

    // Function to insert nodes in level order

    public static void main(String[] args) {
        Integer[] values = { 3,9,20, null, null,15,7 };
        TreeNode node = insertLevelOrder(values);
        VerticalOrderTraversalBinaryTree verticalBinaryTree = new VerticalOrderTraversalBinaryTree();
        List<List<Integer>> result = verticalBinaryTree.verticalTraversal(node);

        System.out.println("result = " + result);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0, 0));
        SortedMap<Integer, SortedMap<Integer, Queue<Integer>>> result = new TreeMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node removed = queue.remove();
                if(!result.containsKey(removed.verticalIndex))
                    result.put(removed.verticalIndex, new TreeMap<>());
                var vertx = result.get(removed.verticalIndex);
                if(vertx.containsKey(removed.levelIndex))
                    vertx.get(removed.levelIndex).add(removed.node.val);
                else {
                    Queue<Integer> pq = new PriorityQueue<>();
                    pq.add(removed.node.val);
                    vertx.put(removed.levelIndex, pq);
                }

                if(removed.node.left != null)
                    queue.add(new Node(removed.node.left, removed.verticalIndex - 1, removed.levelIndex +1));
                if(removed.node.right != null)
                    queue.add(new Node(removed.node.right, removed.verticalIndex + 1, removed.levelIndex +1));
            }

        }

        List<List<Integer>> output = new ArrayList<>();
        for(var vertx: result.values()) {
            List<Integer> verNodes = new ArrayList<>();
            for (Queue<Integer> values : vertx.values())
                while (!values.isEmpty())
                    verNodes.add(values.remove());
            output.add(verNodes);
        }

        return output;
    }

}
