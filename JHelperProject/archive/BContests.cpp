#include <bits/stdc++.h>
using namespace std;

class BContests {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int first = 0, second = 0, third = 0;
        int N, A, B, P;
        cin >> N >> A >> B;
        for (int i = 0; i < N; ++i) {
            cin >> P;
            if(P <= A) first++;
            else if ( P <= B ) second++;
            else third++;
        }
        cout << min( first, min(second, third));
    }
};
