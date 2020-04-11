#include <bits/stdc++.h>
using namespace std;

class CMakeGood {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int t; cin >> t;
        while (t-- > 0) {
            long long n, num; cin >> n;
            long long x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                cin >> num;
                x = x ^ num;
                y += num;
            }
            cout << 2 << endl;
            cout << x << " " << (y + x) << endl;
        }
    }
};
