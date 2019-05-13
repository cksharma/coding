#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
private:
    int ans;

    void solve( TreeNode* root, set<int>& path, int runningSum, int sum ) {
        if( root == nullptr ) return;
        path.insert( runningSum + root->val );
        int compliment = sum - runningSum;
        if( path.find( compliment ) != path.end() ) ++(this->ans);
        solve( root->left, path, runningSum + root->val, sum );
        path.erase( runningSum );
        solve( root->right, path, runningSum + root->val, sum );
    }

public:
    int pathSum(TreeNode* root, int sum) {
        if( root == nullptr ) return 0;
        this->ans = 0;
        set<int> path;
        path.insert(0);
        solve( root, path, 0, sum );
        return ans;
    }
};

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    TreeNode* root = new TreeNode(10);
    root->left = new TreeNode(5);
    root->right = new TreeNode(-3);

    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(2);
    root->right->right = new TreeNode(11);

    root->left->left->left = new TreeNode(3);
    root->left->left->right = new TreeNode(-2);
    root->left->right->right = new TreeNode(1);

    cout << Solution().pathSum(root, 8) << endl;
}
