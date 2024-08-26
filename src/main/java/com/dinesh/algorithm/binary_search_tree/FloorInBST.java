package com.dinesh.algorithm.binary_search_tree;

/**
 *
 * Floor in BST
 * https://www.geeksforgeeks.org/problems/floor-in-bst
 *
 * https://www.youtube.com/watch?v=xm_W1ub-K-w
 *
 */
public class FloorInBST {
    public static int floor(Node root, int x) {
        int floor = -1;

        Node current = root;

        while(current != null) {
            if(current.data == x)
                return current.data;
            if(current.data < x) {
                floor = current.data;
                current = current.right;
            } else {
                current  = current.left;
            }
        }

        return floor;
    }


}
