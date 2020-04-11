#include <bits/stdc++.h>
using namespace std;

class BZuhairAndStrings {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, k; cin >> n >> k;
        string s; cin >> s;

        map<char, int> mp; int cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (s[i - 1] == s[i]) cnt++;
            else { mp[s[i - 1]] += cnt / k; cnt = 1; }
        }
        mp[n - 1] += cnt / k;
        int ans = 0;
        for (auto& [k,v] : mp) ans = max(ans, v);
        cout << ans << endl;
    }
};
