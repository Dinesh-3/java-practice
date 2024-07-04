package com.dinesh.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
 * https://www.youtube.com/watch?v=0ca1nvR0be4
 *
 */
public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(12);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(14);
        tree.right = new TreeNode(22);
        tree.right.right = new TreeNode(25);

        BoundaryTraversal traversal = new BoundaryTraversal();
        traversal.traverse(tree);



    }

    private void traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseLeft(root, result);

        traverseLeaf(root, result);

        traverseRight(root.right, result);

        System.out.println("result = " + result);

    }

    private void traverseRight(TreeNode right, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        TreeNode current = right;

        while (current != null) {
            if(current.left == null && current.right == null)
                break;
            stack.push(current.val);

            if(current.right != null)
                current = current.right;
            else
                current =  current.left;
        }

        while (!stack.isEmpty())
            result.add(stack.pop());

    }

    private void traverseLeaf(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            result.add(root.val);
        }

        traverseLeaf(root.left, result);
        traverseLeaf(root.right, result);
    }

    private void traverseLeft(TreeNode root, List<Integer> result) {

        TreeNode current = root;

        while (current != null) {
            if(current.left == null && current.right == null)
                break;
            result.add(current.val);
            if(current.left != null)
                current =  current.left;
            else
                current = current.right;
        }

    }
}
