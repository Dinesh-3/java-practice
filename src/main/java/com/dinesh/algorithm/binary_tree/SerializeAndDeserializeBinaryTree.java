package com.dinesh.algorithm.binary_tree;

import java.util.*;

/**
 *
 * Serialize and deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/
 * https://www.youtube.com/watch?v=-YbXySKJsX8
 *
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder builder = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            builder.append(node == null ?  "#," : (node.val + ","));

            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] nodes = data.split(",");
        if(nodes.length == 0)
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if(!"#".equals(nodes[index])) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }
            index++;
            if(!"#".equals(nodes[index])) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }
}
