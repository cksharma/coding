#include <bits/stdc++.h>
using namespace std;

class BInterestingSubarray {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int t; cin >> t;
        vector<int> a(2 * (int)1e5 + 2, 0);
        while (t-- > 0) {
            int n, num; cin >> n;
            int index = -1;
            for (int i = 0; i < n; ++i) {
                cin >> num;
                a[i] = num;
                if (index == -1 && i - 1 >= 0 && abs(a[i] - a[i - 1]) > 1) {
                    index = i;
                }
            }
            if (index != -1) {
                cout << "YES\n" << index << " " << index + 1 << endl;
            } else {
                cout << "NO\n" << endl;
            }
        }
    }
};
