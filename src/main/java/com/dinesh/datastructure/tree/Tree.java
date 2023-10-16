package datastructure.tree;

import com.dinesh.datastructure.tree.AVLTree;

import java.util.Arrays;

/**
 * Node -> Contains element
 * Edge -> Lines connecting between Two Nodes
 * Root -> Top Node
 * Leaf -> Last Node
 * Depth -> Numbers of edges from root node to target node ( 0 (root) node to target node )
 * The depth of a node is the number of edges from the node to the tree's root node.
 * A root node will have a depth of 0.
 *
 * Height -> The height of a node is the number of edges on the longest path from the node to a leaf.
 * A leaf node will have a height of 0.
 *
 * The height of a tree would be the height of its root node,
 * or equivalently, the depth of its deepest node.
 *
 * The diameter (or width) of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The tree below has a diameter of 5 nodes.
 *
 * Application:
 *  1. Represent Hierarchical data
 *  2. Databases
 *  3. Autocompletion
 *  4. Compilers
 *  5. Compression (JPEG, MP3)
 *
 */
public class Tree {
    public static void main(String[] args) {

        /**
         *              5
         *           /     \
         *          3       8
         *         / \     /
         *        2   4   6
         *
         * Traversal Types:
         *  1. Breadth First: Level Order Traversal -> Traversing Level By Level = 5 3 8 2 4 6
         *  2. Depth First:
         *      1. PreOrder Traversal -> ROOT LEFT RIGHT = 5 3 2 4 8 6
         *      2. InOrder Traversal -> LEFT ROOT RIGHT (Ascending Order) RIGHT ROOT LEFT (Descending Order) = 2 3 4 5 6 8
         *      3. PostOrder Traversal -> LEFT RIGHT ROOT
         *
         * Depth Of Node:
         *  1. Number of edges from root to target node. Ex depth of 4 is 2 , 8 is 1
         *  2. Or Sum Nodes from root == 0 to target
         *
         */

        datastructure.tree.BinarySearchTree searchTree = new datastructure.tree.BinarySearchTree();

        searchTree.add(5);
        searchTree.add(3);
        searchTree.add(8);
        searchTree.add(2);
        searchTree.add(4);
        searchTree.add(6);

        System.out.println("searchTree.contains(4) = " + searchTree.contains(4));
        System.out.println("searchTree.contains(3) = " + searchTree.contains(3));

        System.out.println("searchTree.preOrderTraversal() = " + Arrays.toString(searchTree.preOrderTraversal()));
        System.out.println("searchTree.inOrderTraversal() = " + Arrays.toString(searchTree.inOrderTraversal()));
        System.out.println("searchTree.postOrderTraversal() = " + Arrays.toString(searchTree.postOrderTraversal()));

        System.out.println("searchTree.height() = " + searchTree.height());

        System.out.println("searchTree.min() = " + searchTree.min());

        System.out.println("searchTree.equals(searchTree) = " + searchTree.equals(searchTree));

        System.out.println(searchTree.isValidBST());

        System.out.println(searchTree.findKthElement(1));

        System.out.println("=== AVL TREE ===");

        AVLTree tree = new AVLTree();

        tree.insert(8);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(5);

    }
}
