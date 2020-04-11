#include <bits/stdc++.h>
using namespace std;

class BTheMonsterAndTheSquirrel {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        cout << ( n - 2LL) * (n - 2LL) << endl;
    }
};
