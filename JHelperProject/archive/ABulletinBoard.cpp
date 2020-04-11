#include <bits/stdc++.h>
using namespace std;

class ABulletinBoard {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int N, H, W; cin >> N >> H >> W;
        cout << (N - H + 1)*(N - W + 1) << endl;
    }
};
