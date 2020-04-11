#include <bits/stdc++.h>
using namespace std;

class EMinimumArray {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; ++i) cin >> arr[i];

        multiset<int> mset;
        for (int i = 0; i < n; ++i) {
            int tmp; cin >> tmp; mset.insert(tmp);
        }

        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            int rem = (n - arr[i]);
            auto it = mset.lower_bound(rem);
            if (it == mset.end()) it = mset.begin();
            ans[i] = (*it + arr[i]) % n;
            mset.erase(it);
        }

        for (int i = 0; i < ans.size(); ++i) cout << ans[i] << " ";
        cout << "\n";
    }
};
