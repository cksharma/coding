package com.careercup.amazon;

public class BinaryTreeUtility {
	public static Tree getBinaryTree() {
		Tree one = new Tree(1);
		Tree two = new Tree(2);
		Tree three = new Tree(3);
		Tree four = new Tree(4);
		Tree five = new Tree(5);
		Tree six = new Tree(6);
		Tree seven = new Tree(7);
		
		two.left = four;
		two.right = five;
		
		three.left = six;
		three.right = seven;
		
		one.left = two;
		one.right = three;
		printTree(one);
		return one;
	}
	
	public static void printTree(Tree root) {
		if (root == null)
			return;
		System.out.print(root.data + "  ");
		printTree(root.left);		
		printTree(root.right);
	}
	public static void main(String[] args) {
		getBinaryTree();
	}
}
