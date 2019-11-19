#include <bits/stdc++.h>
using namespace std;

void solve(vector<vector<int>>& v, int n, int start, int sum, vector<int>& running) {
    if (sum == 0 && n == 0) {
        v.push_back(running);
        return;
    }

    if (sum <= 0 || n <= 0 || start > 9) {
        return;
    }

    running.push_back(start);
    solve(v, n - 1, start + 1, sum - start, running);

    running.pop_back();
    solve(v, n, start + 1, sum, running);

}

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (int item : v) os << item << ", ";z
    return os;
}



struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int height(TreeNode* root) {
    return root ? 1 + height(root->left) : 0;
}

int countNodes(TreeNode* root) {
    if (root == nullptr) return 0;
    int lh = height(root->left);
    int rh = height(root->right);
    if (lh == rh) {
        return (1 << (lh - 1)) + countNodes(root->right);
    }
    return (1 << (rh - 1)) + countNodes(root->left);
}

int main()
{
    vector<vector<int>> ans; vector<int> running;
    int n = 3; int start = 1; int sum = 9;
    solve(ans, n, start, sum, running);
    for (auto& v : ans) cout << v << endl;
}
