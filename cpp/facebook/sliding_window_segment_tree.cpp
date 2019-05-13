#include <bits/stdc++.h>
using namespace std;

struct SegmentTree {
    int from;
    int to;

    int val;
    SegmentTree* left;
    SegmentTree* right;

    SegmentTree(int from, int to, int val) : from(from), to(to), val(val) {}
};

SegmentTree* construct_segement(const vector<int>& v, int from, int to)
{
    int mid = from + (to - from) / 2;
    if (from == mid) return new SegmentTree(from, to, v[from]);

    SegmentTree* left = construct_segement(v, from, mid);
    SegmentTree* right = construct_segement(v, mid, to);
    SegmentTree* me  = new SegmentTree(from, to, max(left->val, right->val));
    me->left = left;
    me->right = right;
    return me;
}

int fetch_segment(SegmentTree* root, int queryStart, int queryEnd) {
    if (root == nullptr) return INT_MIN;
    int from = root->from;
    int to = root->to;

    if (queryStart <= from and queryEnd >= to) return root->val;

    if (queryStart >= to || queryEnd <= from) return INT_MIN;

    int left = fetch_segment(root->left, queryStart, queryEnd);
    int right = fetch_segment(root->right, queryStart, queryEnd);
    return max(left, right);
}

ostream& operator<<(ostream& os, const SegmentTree* tree) {
    os << "[" << tree->from << "," << tree->to <<") => " << tree->val;
    return os;
}

void traverse(SegmentTree* root) {
    if (root == nullptr) return;
    cout << root << endl;
    traverse(root->left);
    traverse(root->right);
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    vector<int> v = {1,3,-1,-3,5,3,6,7}; int k = 3;
    SegmentTree* root = construct_segement(v, 0, v.size());
    traverse(root);
    cout << "=====================" << endl;
    if (k >= v.size())
        cout << root->val << endl;
    else
        for (int i = 0; i + k <= v.size(); i++) {
            int ans = fetch_segment(root, i, i + k);
            cout << "[" << i << "," << (i + k) << "]" << " =>" << ans << endl;
        }
}
