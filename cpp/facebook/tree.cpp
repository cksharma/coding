#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int v) : val(v) {}
};

bool exists(TreeNode* root, int val) {
    if (root == nullptr) return false;
    if (root->val == val) return true;
    if (root->val < val) return exists(root->right, val);
    return exists(root->left, val);
}


int main() {
    TreeNode* root = new TreeNode(5);
    root->left = new TreeNode(3);
    root->right = new TreeNode(7);
    root->left->left = new TreeNode(2);
    root->left->right = new TreeNode(4);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(8);

    cout << exists(root, 8) << endl;
    cout << exists(root, 10) << endl;
}