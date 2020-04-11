#include "header.h"


void recurse(TreeLinkNode* root, TreeLinkNode* parent, bool isLeft) {
	if (root == NULL) return;

	if (isLeft && parent != NULL) {
		root->next = parent->right;
	}
	if (!isLeft && parent != NULL && parent->next != NULL) {
		root->next = parent->next->left;
	}

	recurse(root->left, root, true);

	recurse(root->right, root, false);
}

void PopulatingNextRightPointersInEachNode::connect(TreeLinkNode *root) {
	recurse(root, NULL, false);
}
