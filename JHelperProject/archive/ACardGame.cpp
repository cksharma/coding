#include <bits/stdc++.h>
using namespace std;

class ACardGame {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int t; cin >> t;
        while (t-- > 0) {
            int n, k1, k2, num;
            cin >> n >> k1 >> k2;
            bool first = false;
            for (int i = 0; i < k1; ++i) {
                cin >> num;
                first = first || (num == n);
            }
            for (int i = 0; i < k2; ++i) cin >> num;
            cout << (first ? "YES" : "NO") << endl;
        }
    }
};
