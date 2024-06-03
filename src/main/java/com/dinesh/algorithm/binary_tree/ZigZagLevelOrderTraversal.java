package com.dinesh.algorithm.binary_tree;


import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 */
public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        Set<String> visited = new HashSet<>();
        visited.add("sdfsdf");
        if(visited.contains("sddf"))
            System.out.println("Looks good = ");
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        boolean isZig = false;
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            
            for (int i = 0; i < size; i++) {
                if(queue.isEmpty())
                    break;
                TreeNode current = queue.remove();

                if(isZig)
                    level.add(size - 1 - i, current.val);
                else
                    level.add(current.val);

                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            isZig = !isZig;

            if(!level.isEmpty())
                result.add(level);
        }


        return result;

    }
}
