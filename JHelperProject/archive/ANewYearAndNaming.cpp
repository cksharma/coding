#include <bits/stdc++.h>
using namespace std;

class ANewYearAndNaming {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, m;
        cin >> n >> m;
        vector<string> first(n);
        vector<string> second(m);
        vector<string> ans(n * m);
        for (int i = 0; i < n; ++i) cin >> first[i];
        for (int i = 0; i < m; ++i) cin >> second[i];

        int f = 0, s = 0, cnt = 0;
        while (cnt < n * m) {
            ans[cnt++] = first[f] + second[s];
            f++; s++;
            f %= n;
            s %= m;
        }

        int q, y; cin >> q;
        for (int i = 0; i < q; ++i) {
            cin >> y; y--;
            y %= (n * m);
            cout << ans[y] << endl;
        }
    }
};
