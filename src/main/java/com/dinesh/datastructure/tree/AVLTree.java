package com.dinesh.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class AVLTree {
    private class AVLNode {
        private int value;
        private AVLNode left;
        private AVLNode right;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "value=" + value +
                    ", height=" + height +
                    '}';
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode current, int data) {
        if(current == null)
            return new AVLNode(data);
        if( data < current.value)
            current.left = insert(current.left, data);
        else
            current.right = insert(current.right, data);

        setHeight(current);

        return balance(current);
    }

    private AVLNode balance(AVLNode root) {
        var newRoot = root;
        if(isLeftHeavy(root)) {
            if(balanceFactor(root.left) < 0 ) {
                System.out.println("Left Rotate");
                newRoot.left = leftRotate(root.left);
            }
            newRoot = rightRotate(root);
            System.out.println("Right Rotate");

        }else if(isRightHeavy(root)) {
            if(balanceFactor(root.right) > 0 ) {
                System.out.println("Right Rotate");
                newRoot.right = rightRotate(root.right);
            }
            System.out.println("Left Rotate");
            newRoot = leftRotate(root);

        }

        return newRoot;
    }

    private AVLNode leftRotate(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        if(node == null) return 0;

        return height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        if(node == null)
            return -1;
        return node.height;
    }

}
