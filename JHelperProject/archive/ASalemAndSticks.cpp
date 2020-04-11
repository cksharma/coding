#include <bits/stdc++.h>
using namespace std;

class ASalemAndSticks {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; ++i) cin >> arr[i];

        pair<int, int> ans = make_pair(1, 1 << 30);
        for (int t = 1; t <= 100; ++t) {
            int cost = 0;
            for (int item : arr) {
                if (item > t) cost += item - (t + 1);
                else if (item < t) cost += (t - 1) - item;
            }
            if (cost < ans.second) {
                ans.first = t;
                ans.second = cost;
            }
        }
        cout << ans.first << " " << ans.second << endl;
    }
};
