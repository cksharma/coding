#include <bits/stdc++.h>
using namespace std;

class BPlanningTheExpedition {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int n, m, k; cin >> n >> m;
        map<int, int> count;
        for (int i = 0; i < m; ++i) {
            cin >> k; count[k]++;
        }

        int ans = 0;
        for (int day = 1; day <= m; ++day) {
            int temp = 0;
            for (auto& [k,v] : count) {
                temp += v / day;
            }
            if (temp >= n) {
                ans = max(ans, day);
            }
        }
        cout << ans << endl;
    }
};
