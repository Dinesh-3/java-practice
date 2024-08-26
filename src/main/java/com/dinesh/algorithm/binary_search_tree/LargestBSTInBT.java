package com.dinesh.algorithm.binary_search_tree;

/**
 *
 * Largest BST
 * https://www.geeksforgeeks.org/problems/largest-bst/1
 *
 * https://www.youtube.com/watch?v=X0oXMdtUDwo
 *
 */
public class LargestBSTInBT {
    static class Data {
        int min;
        int max;
        int size;
        public Data(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static int largestBst(Node root)
    {
        return postorder(root).size;
    }

    private static Data postorder(Node node) {
        if(node == null)
            return new Data(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Data left = postorder(node.left);
        Data right = postorder(node.right);
        int size = left.size + right.size + 1;
        if(left.max < node.data && node.data < right.min)
            return new Data(Math.min(left.min, node.data), Math.max(right.max, node.data), size);

        return new Data(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

}
