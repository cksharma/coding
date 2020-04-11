package com.geeks.trees;

public class LCABST { 
    
    private static Tree insertBST(Tree root, int data) {
        if (root == null) {
            return new Tree(data);
        }
        if (root.data > data)
            root.left = insertBST(root.left, data);
        else
            root.right = insertBST(root.right, data);
        return root; 
    }    
    
    private static Tree createBST() {
        int[] arr = new int[] {10, 7, 15, 6, 8, 12, 16, 18};
        Tree root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insertBST(root, arr[i]);
        }
        return root;
    }   
    
    private static Tree findLCA(Tree root, int n1, int n2) {
    	if (root == null) return null;
    	if (n1 < root.data && n2 > root.data) return root;
    	if (root.left != null && (root.left.data == n1 || root.left.data == n2)) return root;
    	if (root.right != null && (root.right.data == n1 || root.left.data == n2)) return root;
    	if (root.data > n1) return findLCA(root.left, n1, n2);
    	else return findLCA(root.right, n1, n2);
    }
    
    public static void main(String[] args) {
    	
    	Tree root = createBST();
        Tree lcaNode = findLCA(root, 12, 18);
        System.out.println(lcaNode.data);
    }
}
