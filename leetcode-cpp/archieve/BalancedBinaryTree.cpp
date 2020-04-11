#include "header.h"

int getHeight(TreeNode *root, bool& value) {
	if (root == NULL) return 0;
	if (root->left == NULL && root->right == NULL) return 1;
	int left_height = 1 + getHeight(root->left, value);
	int right_height = 1 + getHeight(root->right, value);
	if (abs(left_height - right_height) > 1)
		value = false;
	return max(left_height, right_height);
}

bool BalancedBinaryTree::isBalanced(TreeNode * root) {
	bool value = true;
	getHeight(root, value);
	return value;
}



