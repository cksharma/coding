#include <bits/stdc++.h>
using namespace std;

class AStages {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, k; cin >> n >> k;
        string s; cin >> s;
        sort(s.begin(), s.end() );

        auto compute = [](const string& s) {
            int ans = 0;
            for(char ch : s) {
                ans += (ch - 'a' + 1);
            }
            return ans;
        };

        for (int i = 0; i < n; ++i) {
            string ss = string(1, s[i]);
            for (int j = i + 1; j < n && ss.size() < k; ++j) {
                if (ss[ss.size() - 1] + 1 < s[j]) {
                    ss += s[j];
                }
            }
            if( ss.size() == k ) {
                cout << compute(ss) << endl;
                return;
            }
        }
        cout << -1 << endl;
    }
};
