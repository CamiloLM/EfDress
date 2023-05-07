package com.datastructures.efdress;

public class AvlBinarySearch<T extends Comparable<T>> extends
        BinarySearchTree<T> {
    public int path(T data1, T data2) {
        return path(this.root,data1,data2);
    }

    public void insert(T data) {
        this.root = this.insert(this.root, data);
    }

    public void delete(T data) {
        this.root = this.delete(this.root, data);
    }

    public void balance() {
        throw new RuntimeException("Not implemented");
    }

    private TreeNode<T> rotateLeft(TreeNode<T> root) {
        TreeNode<T> x = root.getRight();
        TreeNode<T> z = x.getLeft();
        x.setLeft(root);
        root.setRight(z);
        return x;
    }

    private TreeNode<T> rotateRight(TreeNode<T> root) {
        TreeNode<T> x = root.getLeft();
        TreeNode<T> z = x.getRight();
        x.setRight(root);
        root.setLeft(z);
        return x;
    }

    private TreeNode<T> insert(TreeNode<T> root, T data) {
        if(root == null) root = new TreeNode<>(data);
        else if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if(data.compareTo(root.getKey()) > 0) {
            root.setRight(this.insert(root.getRight(),data));
        }
        return reBalance(root);
    }

    private TreeNode<T> delete(TreeNode<T> root, T data) {
        if(root == null) return root;
        if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.delete(root.getLeft(), data));
        }
        else if (data.compareTo(root.getKey()) > 0) {
            root.setRight(this.delete(root.getRight(), data));
        }
        else {
            if(root.getLeft() == null) return root.getRight();
            else if(root.getRight() == null) return root.getLeft();
            root.setKey(this.minValue(root.getRight()));
            root.setRight(delete(root.getRight(), root.getKey()));
        }
        return reBalance(root);
    }

    private TreeNode<T> reBalance(TreeNode<T> root) {
        if(!this.isBalanced(root)) {
            int difference = this.height(root.getRight()) - this.height(root.getLeft());
            if(difference > 1) {//We need to rotate left
                if(this.height(root.getRight().getRight()) > this.height(root.getRight().getLeft())) { //Only rotate left
                    root = rotateLeft(root);
                } else { //Double rotation
                    root.setRight(rotateRight(root.getRight()));
                    root = rotateLeft(root);
                }
            } else if (difference < -1) {//We need to rotate right
                if(this.height(root.getLeft().getLeft()) > this.height(root.getLeft().getRight())) { //Only rotate right
                    root = rotateRight(root);
                } else { //Double rotation
                    root.setLeft(rotateLeft(root.getLeft()));
                    root = rotateRight(root);
                }
            }
        }
        return root;
    }


    public Integer searchCountStep(TreeNode<T> root, T data1) {
        Integer step=0;
        Object[] found=new Object[2];
        while(true) {
            if(root == null) {
                return null;
            }
            if (data1.compareTo(root.getKey()) < 0) {
                step+=1;
                root=root.getLeft();
            } else if (data1.compareTo(root.getKey()) > 0) {
                step+=1;
                root=root.getRight();
            } else {
                return step;
            }
        }
    }

    public Integer path(TreeNode<T> root, T data1, T data2) {

        if(data1.compareTo(root.getKey())<0 && data2.compareTo(root.getKey())<0){
            return path(root.getLeft(),data1,data2);
        } else if(data1.compareTo(root.getKey())>0 && data2.compareTo(root.getKey())>0){
            return path(root.getRight(),data1,data2);
        } else {
            Object ans1=searchCountStep(root,data1);
            Object ans2=searchCountStep(root,data2);
            if(ans1!=null && ans2!= null){
                return searchCountStep(root,data1)+searchCountStep(root,data2)+1;
            } else{ return -1;}
        }

    }


}