package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * Root to Leaf Paths
 * https://www.geeksforgeeks.org/problems/root-to-leaf-paths
 *
 * https://www.youtube.com/watch?v=fmflMqVOC7k
 *
 */
public class RootToLeafPaths {

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        traverse(root, result, new Stack<>());
        return result;
    }

    private static void traverse(Node root, ArrayList<ArrayList<Integer>> result, Stack<Integer> stack) {
        if(root == null)
            return;
        stack.push(root.data);
        if(root.left == null && root.right == null) {
            result.add(new ArrayList<>(stack));
            stack.pop();
            return;
        }

        traverse(root.left, result, stack);
        traverse(root.right, result, stack);
        stack.pop();
    }

}
