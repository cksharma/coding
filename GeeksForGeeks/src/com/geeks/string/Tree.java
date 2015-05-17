package com.geeks.string;

public class Tree {

    private Tree parent;
    private Tree right;
    private Tree left;
    private int value;
    
    public Tree(Tree parent, Tree left, Tree right, int value) {
           super();
           this.parent = parent;
           this.right = right;
           this.left = left;
           this.value = value;
    }

    public static void inOrder(Tree root)
    {
    	if(root != null) 
    	{
    		System.out.println(root.value);
    		inOrder(root.left);
    		inOrder(root.right);
    	}
    }
    
    public static void main(String[] args) {
           int[] a = new int[15];
           Tree[] treeArray = new Tree[15];
           
           for (int i = 0; i < a.length; i++) {
                  a[i] = i;
           }
           
           for (int i = a.length; i >= 0; i--) {
                  if (i == 0) {
                        continue;
                  }
                  if (i != 1 && 2 * i + 1 < a.length) {
                        treeArray[i] = new Tree(treeArray[i - 1], treeArray[2 * i],treeArray[2 * i + 1], a[i]);
                  } else if (i != 1 && 2 * i < a.length) {
                        treeArray[i] = new Tree(treeArray[i - 1],treeArray[2 * i], null, a[i]);
                  } else if (i == 1) {
                        treeArray[i] = new Tree(null, treeArray[2 * i], treeArray[2 * i + 1], a[i]);
                  }
           }
           Tree one = treeArray[1];
           inOrder(one);           
    }
}
