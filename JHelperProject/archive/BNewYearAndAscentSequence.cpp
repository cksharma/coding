#include <bits/stdc++.h>
using namespace std;

class BNewYearAndAscentSequence {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        vector<int> vfirst;
        vector<int> vsecond;
        long long ans = 1LL * n * n;
        while (n-- > 0) {
            int len; cin >> len;

            bool ok = true;
            int first; cin >> first;
            int prev = first, cur;
            for (int i = 1; i < len; ++i) {
                cin >> cur;
                ok = ok && (prev >= cur);
                prev = cur;
            }
            if (ok) {
                vfirst.push_back(first);
                vsecond.push_back(prev);
            }
        }
        sort(vfirst.begin(), vfirst.end());
        sort(vsecond.begin(), vsecond.end());

        int j = 0;
        for (int i = 0; i < vfirst.size(); ++i) {
            while (j < vsecond.size() && vsecond[j] < vfirst[i]) ++j;
            ans -= (vsecond.size() - j);
        }
        cout << ans << endl;
    }
};
