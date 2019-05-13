#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int ans = INT_MIN;
    //int a = 0;
    void getKthSmallest(TreeNode* root, int k, int& a) {
        if (root == nullptr) return;
        if (k == a) {
            cout << "KYA bakchodi chal raha hai 1" << endl;
            ans = root->val; return;
        }
        if (ans == INT_MIN)
            getKthSmallest(root->left, k, a);
        ++a;
        if (k == a) {
            cout << "KYA bakchodi chal raha hai 2" << endl;
            ans = root->val;
            return;
        }
        if (ans == INT_MIN)
            getKthSmallest(root->right, k, a);
    }

    int kthSmallest(TreeNode* root, int k) {
        int a = 0;
        getKthSmallest(root, k, a);
        return ans;
    }
};

int main() {
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(1);
    root->left->right = new TreeNode(2);
    root->right = new TreeNode(4);
    Solution sol;
    cout << sol.kthSmallest(root, 4) << endl;
}