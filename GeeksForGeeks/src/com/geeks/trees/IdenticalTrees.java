package com.geeks.trees;

public class IdenticalTrees {
    public static void main(String[] args) {
        Tree t1 = new Tree(2);
        t1.left = new Tree(1);
        t1.right = new Tree(3);
        Tree t2 = new Tree(2);
        t2.left = new Tree(1);
        t2.right = new Tree(3);
        
        boolean isIdentical = isIdenticalTrees(t1, t2);
        System.out.println("Is identical " + isIdentical);
    }
    public static boolean isIdenticalTrees(Tree t1, Tree t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null || t1.data != t2.data) return false;
        return isIdenticalTrees(t1.left, t2.left) && isIdenticalTrees(t1.right, t2.right);        
        
    }
}