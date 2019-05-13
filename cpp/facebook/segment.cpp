#include <bits/stdc++.h>
using namespace std;

struct Segment {
    int from;
    int to;
    int val;

    Segment(int from, int to, int val) : from(from), to(to), val(val) {}

    Segment* left;
    Segment* right;
};

int update(int val, int idx, Segment* root) {
    if (root == nullptr) return INT_MAX;
    int start = root->from; int end = root->to;
    if (start == end && idx == start) {
        root->val = val;
        return val;
    }
    if (start < idx and end < idx) return root->val;
    if (start > idx and end > idx) return root->val;
    int left = update(val, idx, root->left);
    int right = update(val, idx, root->right);
    root->val = min(left, right);
    return root->val;
}

Segment* segment(const vector<int>& v, int start, int end) {
    if (start == end) {
        Segment* seg = new Segment(start, end, v[start]);
        return seg;
    }

    int mid = start + (end - start) / 2;
    Segment* left = segment(v, start, mid);
    Segment* right = segment(v, mid + 1, end);
    Segment* me = new Segment(start, end, min(left->val, right->val));
    me->left = left;
    me->right = right;
    return me;
}

void traverse(Segment* root) {
    if (root == nullptr) return;
    cout << "[" << root->from << "-" << root->to << "]" << root->val << endl;
    traverse(root->left);
    traverse(root->right);
}

void segment_construction()
{
    vector<int> v = {5, 3, 1, 4, 2, 8, 7, 6};
    Segment* root = segment(v, 0, v.size() - 1);
    traverse(root);

    cout << "UPDATE" << endl;
    v[2] = 10;
    update(10, 2, root);
    traverse(root);
}

int kadane() {
    vector<int> v = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int ans = *max_element(v.begin(), v.end());
    if (ans <= 0) return ans;
    int runningSum = 0;
    for (int i = 0; i < v.size(); ++i) {
        if (runningSum + v[i] > 0) {
            runningSum += v[i];
        } else {
            runningSum = 0;
        }
        ans = max(ans, runningSum);
    }
    cout << "max contigious sum <" << ans << ">" << endl;
    return ans;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    segment_construction();
    kadane();
}
