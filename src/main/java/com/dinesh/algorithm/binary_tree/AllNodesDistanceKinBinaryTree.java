package com.dinesh.algorithm.binary_tree;

import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
 *
 *
 */
public class AllNodesDistanceKinBinaryTree {
    class Pair {
        int distance;
        TreeNode node;
        public Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, TreeNode> map = new HashMap<>();

        while(!queue.isEmpty()) {
            int length = queue.size();

            for(int i = 0; i < length; i++) {
                TreeNode node = queue.remove();
                if(node.left != null) {
                    map.put(node.left, node);
                    queue.add(node.left);
                }

                if(node.right != null) {
                    map.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }

        Set<TreeNode> visited = new HashSet<>();

        Queue<Pair> queue1 = new LinkedList<>();

        queue1.add(new Pair(target, 0));

        while(!queue1.isEmpty()) {
            int length = queue1.size();
            for(int i = 0; i < length; i++) {
                Pair pair = queue1.remove();
                TreeNode node = pair.node;
                if(visited.contains(pair.node))
                    continue;
                visited.add(pair.node);
                if(pair.distance == k) {
                    result.add(pair.node.val);
                } else {
                    if(node.left != null)
                        queue1.add(new Pair(node.left, pair.distance + 1));
                    if(node.right != null)
                        queue1.add(new Pair(node.right, pair.distance + 1));
                    if(map.get(node) != null)
                        queue1.add(new Pair(map.get(node), pair.distance + 1));
                }
            }
        }

        return result;

    }

    private Optional<TreeNode> getNode(TreeNode root, int target) {
        if(root == null)
            return Optional.empty();
        if(root.val == target)
            return Optional.of(root);
        Optional<TreeNode> left = getNode(root.left, target);
        Optional<TreeNode> right = getNode(root.right, target);

        if(left.isPresent())
            return left;

        return right;
    }

}
