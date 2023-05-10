package com.datastructures.efdress;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class AVLTree{
    
    protected TreeNode root;
    protected int index;
  
    public Articulo search(int id) {
        return this.search(this.root, id);
    }
    
    public ArrayList<Articulo> search(String pattern) {
        return this.search(this.root, pattern);
    }
    
    public void insert(Articulo data) {
        this.root = this.insert(this.root, data);
    }
    
    public int index() {
        return this.index;
    }

    public void delete(int id) {
        this.root = this.delete(this.root, id);
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

    public Articulo minValue() {
        return this.minValue(this.root);
    }

    public Articulo maxValue() {
        return this.maxValue(this.root);
    }

    public boolean isBalanced() {
        return this.isBalanced(root);
    }

    private TreeNode rotateLeft(TreeNode root) {
        TreeNode x = root.getRight();
        TreeNode z = x.getLeft();
        x.setLeft(root);
        root.setRight(z);
        return x;
    }

    private TreeNode rotateRight(TreeNode root) {
        TreeNode x = root.getLeft();
        TreeNode z = x.getRight();
        x.setRight(root);
        root.setLeft(z);
        return x;
    }

    private TreeNode insert(TreeNode root, Articulo data) {
        if(root == null) {
            root = new TreeNode(data);
            index++;
        }
        else if(data.compareTo(root.getKey()) < 0) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if(data.compareTo(root.getKey()) > 0) {
            root.setRight(this.insert(root.getRight(),data));
        }
        return reBalance(root);
    }

    private Articulo search(TreeNode root, int id) {
        if (root == null) return null;
        TreeNode current = root;
        while (current != null) {
            if (id > current.getKey().getId()){
                current = current.getRight();
            }
            else if (id < current.getKey().getId()) {
                current = current.getLeft();
            } else {
                return current.getKey();
            }
        }
        return null;
    }
    
    private ArrayList<Articulo> search(TreeNode root, String pattern) {
        ArrayList<Articulo> results = new ArrayList<>();
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (stack.empty() == false) {
            TreeNode current = stack.peek();
            if (current.getKey().getNombre().contains(pattern)) {
                results.add(current.getKey());
            }
            stack.pop();
            
            if (current.getRight() != null) stack.push(current.getRight());
            if (current.getLeft() != null) stack.push(current.getLeft());
        }
        return results;
    }
    
    private TreeNode findFather(TreeNode root, Articulo data) {
        TreeNode current = root;
        TreeNode prev = null;
        while (current != null) {
            if (data.compareTo(current.getKey()) > 0) {
                prev = current;
                current = current.getRight();
            } else if (data.compareTo(current.getKey()) < 0) {
                prev = current;
                current = current.getLeft();
            } else {
                return prev;
            }
        }
        return prev;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int height = 0;
        
        while(true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) return height;
            height++;
            
            while (nodeCount > 0) {
                TreeNode newNode = queue.peek();
                queue.remove();
                if (newNode.getLeft() != null) queue.add(newNode.getLeft());
                if (newNode.getRight() != null) queue.add(newNode.getRight());
                nodeCount--;
            }
        }
    }

    @Override
    public String toString() {
        return this.toString(this.root);
    }

    private String toString(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        if(root == null) return "";
        queue.add(root);
        level.add(0);
        StringBuilder sb = new StringBuilder();
        int preLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int l = level.poll();
            if(preLevel != l) {
                sb.append("\n");
                preLevel = l;
            }
            sb.append(temp.getKey().getId()).append(" ");
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

    private TreeNode delete(TreeNode root, int id) {
        if(root == null) return root;
        if(id < root.getKey().getId()) {
            root.setLeft(this.delete(root.getLeft(), id));
        }
        else if (id > root.getKey().getId()) {
            root.setRight(this.delete(root.getRight(), id));
        }
        else {
            if(root.getLeft() == null) return root.getRight();
            else if(root.getRight() == null) return root.getLeft();
            root.setKey(this.minValue(root.getRight()));
            root.setRight(delete(root.getRight(), root.getKey().getId()));
        }
        return reBalance(root);
    }
    
    private TreeNode reBalance(TreeNode root) {
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

    private void inOrder(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.getLeft() == null) {
                System.out.print(current.getKey() + " ");
                current = current.getRight();
            }
            else {
                TreeNode temp = current.getLeft();
                while (temp.getRight() != null && temp.getRight() != current) {
                    temp = temp.getRight();
                }
                if (temp.getRight() == null) {
                    temp.setRight(current);
                    current = current.getLeft();
                }
                else {
                    temp.setRight(null);
                    System.out.print(current.getKey() + " ");
                    current = current.getRight();
                }
            }
        }     
    }
    
    private int size(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int count = 1;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                if (temp.getLeft() != null) {
                    count++;
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    count++;
                    queue.add(temp.getRight());
                }
            }
        }
        return count;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (stack.empty() == false) {
            TreeNode current = stack.peek();
            System.out.print(current.getKey() + " ");
            stack.pop();
            
            if (current.getRight() != null) stack.push(current.getRight());
            if (current.getLeft() != null) stack.push(current.getLeft());
        }
    }
    
    private void postOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (true) {
            while(current != null) {
                stack.push(current);
                stack.push(current);
                current = current.getLeft();
            }

            if(stack.empty()) {
                return;
            }
            current = stack.pop();
            
            if (!stack.empty() && stack.peek() == current) {
                current = current.getRight();
            }
            else {
                System.out.print(current.getKey() + " ");
                current = null;
            }
        }
    }

    private Articulo minValue(TreeNode root) {
        TreeNode current = root;
        while (current.getLeft() != null) current = current.getLeft();
        return current.getKey();
    }

    private Articulo maxValue(TreeNode root) {
        TreeNode current = root;
        while (current.getRight() != null) current = current.getRight();
        return current.getKey();
    }

    private boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current;
        int lh;
        int rh;
        stack.push(root);
        while (stack.empty() == false) {
            current = stack.pop();
            if (current != null) {
                lh = this.height(current.getLeft());
                rh = this.height(current.getRight());
                if(Math.abs(lh - rh) > 1) return false;
                stack.push(current.getLeft());
                stack.push(current.getRight());
            }
        }
        return true;
    }
}
