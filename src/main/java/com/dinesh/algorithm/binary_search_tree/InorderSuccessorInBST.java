package com.dinesh.algorithm.binary_search_tree;

/**
 *
 * Inorder Successor in BST
 * https://www.geeksforgeeks.org/problems/inorder-successor-in-bst
 *
 * https://www.youtube.com/watch?v=SXKAD2svfmI
 *
 */
public class InorderSuccessorInBST {

    class Result {
        Node suc;
    }

    public Node inorderSuccessor(Node root,Node x)
    {
        Result res = new Result();
        dfs(root, x, res);
        return res.suc;
    }

    private void dfs(Node root, Node x, Result res) {
        if(root == null)
            return;

        if(res.suc != null)
            return;

        dfs(root.left, x, res);
        if(root.data > x.data && res.suc == null)
            res.suc = root;
        dfs(root.right, x, res);
    }

    public Node inorderSuccessorOptimal(Node root,Node x)
    {

        Node successor = null;

        Node current = root;

        while(current != null) {
            if(current.data <= x.data)
                current = current.right;
            else {
                successor = current;
                current = current.left;
            }
        }

        return successor;
    }

}
