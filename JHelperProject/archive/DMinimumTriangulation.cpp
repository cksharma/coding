#include <bits/stdc++.h>
using namespace std;

class DMinimumTriangulation {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n; int a = 2, b = 3; long long ans = 0;
        for (int i = 3; i <= n; ++i) {
            ans += a * b;
            a++;
            b++;
        }
        cout << ans << endl;
    }
};
