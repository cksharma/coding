#include <bits/stdc++.h>
using namespace std;

class ARightTriangle {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int a, b, c; cin >> a >> b >> c;
        cout << (a * b) / 2 << endl;
    }
};