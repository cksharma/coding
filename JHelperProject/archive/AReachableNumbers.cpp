#include <bits/stdc++.h>
using namespace std;

class AReachableNumbers {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        set<int> visited;
        while (true and n > 0) {
            if (visited.find(n) != visited.end()) break;
            visited.insert(n);
            n++;
            while (n % 10 == 0 and n > 0) n /= 10;
        }
        cout << visited.size() << endl;
    }
};
