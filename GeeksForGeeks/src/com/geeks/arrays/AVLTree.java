package com.geeks.arrays;
import static java.lang.Math.max;

public class AVLTree {
	int data;
	int height;
	AVLTree left;
	AVLTree right;

	public AVLTree(int data) {
		super();
		this.data = data;	
		//this.height = 1;
	}

	public AVLTree insert(int data) {
		AVLTree root = this;
		root = insertAVL(root, data);
		return root;
	}

	private AVLTree insertAVL(AVLTree root, int data) {
		if (root == null) {
			root = new AVLTree(data);
		} else if (root.data < data) {
			root.right = insertAVL(root.right, data);
			if (balanceFactor(root) == -2) {
				if (root.right.data > data) {
					root.right = rotateRight(root.right);
				}				
				root = rotateLeft(root);
			}
		} else if (root.data > data) {
			root.left = insertAVL(root.left, data);
			if (balanceFactor(root) == 2) {
				if (root.left.data < data) {
					root.left = rotateLeft(root.left);
				}
				root = rotateRight(root);
			}
		}
		root.height = height(root);
		return root;
	}	
	
	private AVLTree rotateLeft(AVLTree root) {
		AVLTree newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		return newRoot;
	}

	private AVLTree rotateRight(AVLTree root) {
		AVLTree newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		return newRoot;
	}

	private int balanceFactor(AVLTree root) {
		int lf = 0, rf = 0;
		if (root.left != null)
			lf = root.left.height;
		if (root.right != null)
			rf = root.right.height;
		return lf - rf;
	}

	public void printTree(AVLTree root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.println(root.data + " --> " + balanceFactor(root));
		printTree(root.right);
	}
		
	private int height(AVLTree root) {
		int lh = 0, rh = 0;
		if (root == null) return 0;
		if (root.left != null) lh = 1 + root.left.height;
		if (root.right != null) rh = 1 + root.right.height;
		return max(lh, rh);
	}
	/*public void printStackTraceOfTree(AVLTree root) {
		if (root == null) return;
		System.out.println(root.data + " " + balanceFactor(root));
		printStackTraceOfTree(root.left);
		printStackTraceOfTree(root.left);
	}*/
}
