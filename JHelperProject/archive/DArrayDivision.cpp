#include <bits/stdc++.h>
using namespace std;

class DArrayDivision {
public:
    using ll = long long;

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int n; cin >> n;
        vector<ll> arr(n);
        for(int i = 0; i < n; ++i) cin >> arr[i];
        vector<ll> cumu(n, 0); cumu[0] = arr[0];
        for(int i = 1; i < n; ++i) cumu[i] = cumu[i - 1] + arr[i];

        ll sum = cumu[n - 1];
        if( sum % 2 == 1) {
            cout << "NO" << endl;
            return;
        }

        ll expected = sum / 2;
        for(int i = 0; i < n; ++i) {
            ll me = arr[i];
            ll desired = me + expected;
            ll missing = expected - me;
            bool found = binary_search(cumu.begin() + i, cumu.end(), desired ) ||
                    (missing > 0 && binary_search(cumu.begin(), cumu.begin() + i, missing ) );
            if( found || cumu[i] == expected ) {
                cout << "YES" << endl;
                return;
            }
        }
        cout << "NO" << endl;
    }
};
