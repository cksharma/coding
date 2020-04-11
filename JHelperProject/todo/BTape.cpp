#include <bits/stdc++.h>
using namespace std;

class BTape {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, m, k; cin >> n >> m >> k;
        vector<int> b(n);
        for (int i = 0; i < n; ++i) cin >> b[i];

        vector<int> diff(n - 1);
        for (int i = 1; i < b.size(); ++i) diff[i - 1] = b[i] - b [i - 1] - 1;

        sort(diff.rbegin(), diff.rend());

        int ans = b[n - 1] - b[0] + 1;
        for (int i = 0; i < k - 1 && i < diff.size(); ++i) {
            ans -= diff[i];
        }
        cout << ans << endl;
    }
};
