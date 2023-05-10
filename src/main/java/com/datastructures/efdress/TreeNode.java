package com.datastructures.efdress;


public class TreeNode {
    private Articulo key;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Articulo key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public Articulo getKey() {
        return key;
    }

    public void setKey(Articulo key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}

