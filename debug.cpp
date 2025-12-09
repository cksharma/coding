#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

void solve() {
    int n;
    cin >> n;
    vector<long long> a(n);
    long long max_val = -1;
    int max_idx = -1;
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        if (a[i] > max_val) {
            max_val = a[i];
            max_idx = i;
        }
    }

    cerr << "Original: ";
    for (auto x : a) cerr << x << " ";
    cerr << "\nMax: " << max_val << " at index " << max_idx << "\n";

    // Rotate so a[0] is the maximum element
    rotate(a.begin(), a.begin() + max_idx, a.end());

    cerr << "Rotated: ";
    for (auto x : a) cerr << x << " ";
    cerr << "\n";

    // Create b array with appended max element
    vector<long long> b = a;
    b.push_back(a[0]);

    cerr << "Array b: ";
    for (auto x : b) cerr << x << " ";
    cerr << "\n";

    int m = b.size();
    vector<int> L(m), R(m);
    stack<int> s;

    // Find Previous Greater Equal (L)
    for (int i = 0; i < m; ++i) {
        while (!s.empty() && b[s.top()] < b[i]) {
            s.pop();
        }
        if (s.empty()) {
            L[i] = -1;
        } else {
            L[i] = s.top();
        }
        s.push(i);
    }

    while (!s.empty()) s.pop();

    // Find Next Greater Equal (R)
    for (int i = m - 1; i >= 0; --i) {
        while (!s.empty() && b[s.top()] < b[i]) {
            s.pop();
        }
        if (s.empty()) {
            R[i] = -1;
        } else {
            R[i] = s.top();
        }
        s.push(i);
    }

    cerr << "L: ";
    for (int i = 0; i < m; ++i) cerr << L[i] << " ";
    cerr << "\nR: ";
    for (int i = 0; i < m; ++i) cerr << R[i] << " ";
    cerr << "\n";

    long long total_cost = 0;
    for (int i = 1; i < n; ++i) {
        long long left_val = (L[i] != -1) ? b[L[i]] : 2e18;
        long long right_val = (R[i] != -1) ? b[R[i]] : 2e18;
        long long cost = min(left_val, right_val);
        cerr << "i=" << i << " val=" << b[i] << " L=" << L[i] << "(" << left_val << ") R=" << R[i] << "(" << right_val << ") cost=" << cost << "\n";
        total_cost += cost;
    }

    cout << total_cost << endl;
    cerr << "---\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
