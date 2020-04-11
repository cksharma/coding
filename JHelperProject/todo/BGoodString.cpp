#include <bits/stdc++.h>
using namespace std;

class BGoodString {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int t; cin >> t;
        for (int i = 0; i < t; ++i) {
            int n; cin >> n;
            string str; cin >> str;
            int ans = 0;
            for (int i = 1; i < n; ++i) {
                if (str[i] == '>' && str[i - 1] == '<') ans++;
            }
            cout << ans << endl;
        }
    }
};
