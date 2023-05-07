package com.datastructures.efdress;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree<T extends Comparable<T>> {

    protected TreeNode<T> root;

    public BinarySearchTree(T data) {
        this.root = new TreeNode<>(data);
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean search(T data) {
        return this.search(this.root, data) != null;
    }

    public void insert(T data) {
        this.root = this.insert(this.root, data);
    }

    public void delete(T data) {
        this.root = this.delete(this.root, data);
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void postOrder() {
        this.postOrder(this.root);
    }


    public int height() {
        return this.height(this.root);
    }

    public int size() {
        return this.size(root);
    }

    public T minValue() {
        return this.minValue(this.root);
    }

    public T maxValue() {
        return this.maxValue(this.root);
    }

    public boolean isBalanced() {
        return this.isBalanced(root);
    }

    public void balance() {
        ArrayList<T> values = new ArrayList<>();
        this.inOrder(root, values);
        this.buildTree(values);
    }

    private void buildTree(ArrayList<T> values) {
        this.root = buildTreeUtil(0, values.size() - 1, values);
    }

    private TreeNode<T> buildTreeUtil(int start, int end, ArrayList<T> values) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode<T> root = new TreeNode<>(values.get(mid));
        root.setLeft(this.buildTreeUtil(start, mid-1, values));
        root.setRight(this.buildTreeUtil(mid+1,end,values));
        return root;
    }

    private void inOrder(TreeNode<T> root, ArrayList<T> values) {
        if(root == null) return;
        this.inOrder(root.getLeft(), values);
        values.add(root.getKey());
        this.inOrder(root.getRight(), values);
    }

    public String toString() {
        return this.toString(this.root);
    }

    private String toString(TreeNode<T> root) {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        if(root == null) return "";
        queue.add(root);
        level.add(0);
        StringBuilder sb = new StringBuilder();
        int preLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode<T> temp = queue.poll();
            int l = level.poll();
            if(preLevel != l) {
                sb.append("\n");
                preLevel = l;
            }
            sb.append(temp.getKey() + " ");
            if(temp.getLeft() != null) {
                queue.add(temp.getLeft());
                level.add(l + 1);
            }
            if(temp.getRight() != null) {
                queue.add(temp.getRight());
                level.add(l + 1);
            }
        }
        return sb.toString();
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
        return root;
    }

    private int size(TreeNode<T> root) {
        if(root == null)  return 0;
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    protected int height(TreeNode<T> root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    protected T minValue(TreeNode<T> root) {
        if(root == null) return null;
        if(root.getLeft() == null) return root.getKey();
        else return minValue(root.getLeft());
    }

    private T maxValue(TreeNode<T> root) {
        if(root == null) return null;
        if(root.getRight() == null) return root.getKey();
        else return maxValue(root.getRight());
    }

    private void inOrder(TreeNode<T> root) {
        if(root == null) return;
        this.inOrder(root.getLeft());
        System.out.print(root.getKey() + " ");
        this.inOrder(root.getRight());
    }

    private void preOrder(TreeNode<T> root) {
        if(root == null) return;
        System.out.print(root.getKey() + " ");
        this.inOrder(root.getLeft());
        this.inOrder(root.getRight());
    }

    private void postOrder(TreeNode<T> root) {
        if(root == null) return;
        this.inOrder(root.getLeft());
        this.inOrder(root.getRight());
        System.out.print(root.getKey() + " ");
    }

    private TreeNode<T> insert(TreeNode<T> root, T data) {
        if(root == null) root = new TreeNode<>(data);
        else if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if(data.compareTo(root.getKey()) > 0) {
            root.setRight(this.insert(root.getRight(),data));
        }
        return root;
    }

    private T search(TreeNode<T> root, T data) {
        if(root == null) return null;
        if(root.getKey().compareTo(data) == 0) {
            return root.getKey();
        }
        else if(data.compareTo(root.getKey()) < 0) {
            return this.search(root.getLeft(),data);
        }
        else return this.search(root.getRight(), data);
    }

    protected boolean isBalanced(TreeNode<T> root) {
        if(root == null) return true;
        int lh = this.height(root.getLeft());
        int rh = this.height(root.getRight());
        if(Math.abs(lh - rh) > 1) return false;
        return this.isBalanced(root.getLeft()) && this.isBalanced(root.getRight());
    }

}