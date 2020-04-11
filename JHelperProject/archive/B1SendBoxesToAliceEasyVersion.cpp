#include <bits/stdc++.h>
using namespace std;

class B1SendBoxesToAliceEasyVersion {
public:
    const int INF = INT32_MIN;

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        vector<int> input(n);
        for (int i = 0; i < n; ++i) {
            cin >> input[i];
        }
        int sum = accumulate(input.begin(), input.end(), 0);
        if (sum <= 1) {
            cout << "-1" << endl;
            return;
        }
        vector<pair<int, int>> vp;
        int leftPos = -1;
        for (int i = 0; i < input.size(); ++i) {
            if (input[i] == 0) continue;
            if (leftPos == -1) {
                vp.push_back({INF, INF});
            } else {
                vp[vp.size() - 1].second = i - leftPos;
                vp.push_back( { i - leftPos, INF} );
            }
            leftPos = i;
        }
        vp[vp.size() - 1].second = INF;
        //for (int i = 0; i < vp.size(); ++i)
        //    cout << "(" << vp[i].first << ", " << vp[i].second << ")" << endl;
        int ans = 0;
        for (int i = 0; i < vp.size(); i += 2) {
            if (vp[i].second != INF) {
                ans += vp[i].second;
            } else {
                ans += vp[i].first;
            }
        }
        cout << ans << endl;
    }
};
