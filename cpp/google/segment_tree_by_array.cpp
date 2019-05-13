#include <bits/stdc++.h>
using namespace std;

vector<int> segTree;

int construct_segment_tree(int pos, const vector<int>& input, int low, int high)
{
    if (low == high) {
        segTree[pos] = input[high];
        cout << "pos1 = " << pos << endl;
        return segTree[pos];
    }
    int mid = low + (high - low) / 2;
    int left = construct_segment_tree(2 * pos + 1, input, low, mid);
    int right = construct_segment_tree(2 * pos + 2, input, mid + 1, high);
    segTree[pos] = min(left, right);
    cout << "pos2 = " << pos << endl;
    return segTree[pos];
}

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (int item : v) os << item << ", ";
    return os;
}

int rmq(int qlow, int qhigh, int low, int high, int pos)
{
    if (qlow <= low and qhigh >= high) { // total overlap
        return segTree[pos];
    }

    // no overlap at all
    if (qhigh < low || qlow > high) return INT_MAX;

    int smid = low + (high - low) / 2;
    int left = rmq(qlow, qhigh, low, smid, 2 * pos + 1);
    int right = rmq(qlow, qhigh, smid + 1, high, 2 * pos + 2);
    return min(left, right);
}

int query(int qlow, int qhigh, const vector<int>& input) {
    return rmq(qlow, qhigh, 0, input.size() - 1, 0);
}

int increment(int qlow, int qhigh, const vector<int>& input) {

}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    vector<int> input {-1, 3, 4, 0, 2, 1};
    //input = {-1, 3, 4};
    int H = pow(2, ceil(log2(input.size()))); cout << "H = " << H << endl;
    segTree.resize(2 * H - 1);
    fill(segTree.begin(), segTree.end(), INT_MAX);
    construct_segment_tree(0, input, 0, input.size() - 1);

    cout << "MY SIZE=" << segTree.size() << endl;
    cout << (segTree) << endl;

    //cout << "CKS min[0, 1] = " << query(0, 1, input) << endl;
    //cout << "CKS min[0, 5] = " << query(0, 5, input) << endl;
    //cout << "CKS min[1, 3] = " << query(1, 3, input) << endl;
    //cout << "CKS min[1, 4] = " << query(1, 4, input) << endl;
    cout << "CKS min[3, 5] = " << query(3, 5, input) << endl;
    cout << "CKS min[4, 5] = " << query(4, 5, input) << endl;
}
