package com.dinesh.algorithm.binary_search_tree;

/**
 *
 * Ceil in a Binary Search Tree
 * https://takeuforward.org/binary-search-tree/ceil-in-a-binary-search-tree/
 *
 * https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst
 *
 */
public class CeilInBST {
    int findCeil(Node root, int key) {
        if (root == null) return -1;

        int ceil = -1;
        Node current = root;

        while(current != null) {
            if(current.data == key)
                return key;
            if(current.data > key) {
                ceil = current.data;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return ceil;

    }

}
