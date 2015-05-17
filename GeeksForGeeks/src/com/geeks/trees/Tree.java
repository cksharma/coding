package com.geeks.trees;

class Tree {
	int data;
	Tree left;
	Tree right;
	public Tree(int data) {
		super();
		this.data = data;
	}
	public static Tree treeGiven() {
		Tree tree = new Tree(10);
		Tree root = tree;
		tree.left = new Tree(5);
		tree.right = new Tree(20);
		return root;
	}
	
	public void printTree() {
		preorder(this);
	}
	
	private void preorder (Tree tree) {
		if (tree == null) return;
		preorder(tree.left);
		System.out.print(tree.data + "-->");
		preorder(tree.right);
	}
	
	public Tree insertTree (int data) {
		Tree that = this;
		doInsertBST(that, data);
		return that;
	}
	
	private void doInsertBST (Tree tree, int x) {
		if (tree == null) {
			tree = new Tree(x);
			return;
		}
		if (tree.data > x && tree.left == null) {
			tree.left = new Tree(x);
		} else if (tree.data < x && tree.right == null) {
			tree.right = new Tree(x);
		} else if (tree.data > x) {
			doInsertBST(tree.left, x);
		} else {
			doInsertBST(tree.right, x);
		}		
	}
}