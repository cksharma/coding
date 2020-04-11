#include <bits/stdc++.h>
using namespace std;

class BCollatzProblem {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        long long s; cin >> s;
        set<int> visited;
        int steps = 1;
        long long a = s;
        while (visited.find(a) == visited.end()) {
            visited.insert(a);
            if (a % 2 == 0) a /= 2;
            else a = 3 * a + 1;
            ++steps;
        }
        cout << steps << endl;
    }
};
