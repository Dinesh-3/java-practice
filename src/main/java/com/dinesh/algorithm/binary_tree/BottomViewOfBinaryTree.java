package com.dinesh.algorithm.binary_tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.youtube.com/watch?v=0FtVY6I4pB8
 *
 * https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
 *
 * https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/
 */
public class BottomViewOfBinaryTree {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
        /**
         *                       20
         *                     /    \
         *                   8       22
         *                 /   \       \
         *               5      3       25
         *                      /\
         *                  10    14
         */
        Node node = new Node(20);
        node.left = new Node(8);
        node.left.left = new Node(5);
        node.left.right = new Node(3);
        node.left.right.left = new Node(10);
        node.left.right.right = new Node(14);
        node.right = new Node(22);
        node.right.right = new Node(25);

        List<Integer> result = tree.bottomView(node);
        System.out.println("result = " + result);
    }

    public List<Integer> bottomView(Node root)
    {
        Set<Integer> list = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        bottomView(root, list, result, 0);
        return result;
    }

    private void bottomView(Node current, Set<Integer> list, List<Integer> result, int level) {
        if(current == null)
            return;
        bottomView(current.left, list, result, level - 1);
        bottomView(current.right, list, result, level + 1);
        if(list.contains(level))
            return;
        list.add(level);
        result.add(current.data);
    }

}
