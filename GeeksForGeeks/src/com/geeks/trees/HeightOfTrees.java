package com.geeks.trees;

public class HeightOfTrees {
    public static void main(String[] args) {
        HeightOfTrees ht = new HeightOfTrees();
        
        int[] arr = new int[]{5, 3, 6, 9, 10, 1};
        Tree tree = null;
        
        for (int i = 0; i < arr.length; i++) {
            tree = ht.insertBST(tree, arr[i]);
        }        
        ht.inorder(tree);
        System.out.println();
        
        int height = ht.height(tree);
        System.out.println("Height of trees " + height);
        
        boolean isBst = ht.isBST(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println("Is Tree BST : " + isBst);
        
    }
    
    public boolean isBST(Tree tree, int max, int min) {
        if (tree == null) return true;
        if (tree.data < min || tree.data > max) return false;
        return isBST(tree.left, tree.data - 1, min) && isBST(tree.right, max, tree.data + 1);
    }
    
    public Tree insertBST(Tree tree, int data) {
        if (tree == null) return new Tree(data);
        if (tree.left == null && tree.right == null) {
            if (tree.data > data) {
                tree.left = new Tree(data);
            } else {
                tree.right = new Tree(data);
            }
            return tree;
        }
        if (tree.data > data) {
            tree.left = insertBST(tree.left, data);
        } else {
            tree.right = insertBST(tree.right, data);
        }
        return tree;
    }
    
    public void inorder(Tree tree) {
        if (tree == null) return;
        inorder(tree.left);
        System.out.print(tree.data + " ");
        inorder(tree.right);
    }
    
    public int height(Tree tree) {
       if (tree == null) return 0;
       if (tree.left == null && tree.right == null) return 1;
       return 1 + Math.max(height(tree.left), height(tree.right));
    }
}
