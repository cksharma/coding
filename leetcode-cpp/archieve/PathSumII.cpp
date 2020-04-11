#include "header.h"

void PathSumII::recurse(TreeNode* root, int running_sum, int height, vector <int> v) {
	
	if (root == NULL) return;
	if (v.size() > height) {
		v.insert(v.begin() + height, root->val);
	} else {
		v.push_back(root->val);
	}

	if (root->left == NULL && root->right == NULL) {
		if (running_sum + root->val == sum) {
			vector <int> kk;
			for (int k = 0; k < height + 1; k++)
				kk.push_back(v[k]);
			ans.push_back(kk);
		}
	}
	recurse(root->left, running_sum + root->val, height + 1, v);
	recurse(root->right, running_sum + root->val, height + 1, v);
}

vector<vector<int>> PathSumII::pathSum(TreeNode *root, int sum) {
	this->sum = sum;
	vector <int> v;
	recurse(root, 0, 0, v);
	return ans;
}

