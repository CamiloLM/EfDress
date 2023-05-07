package com.datastructures.efdress;

public class TreeNode<T> {
    private T key;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

}