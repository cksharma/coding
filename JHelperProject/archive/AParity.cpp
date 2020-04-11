#include <bits/stdc++.h>
using namespace std;

class AParity {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int b, k; cin >> b >> k;
        vector<int> arr(k);
        for (int& item : arr) cin >> item;

        int odd_count = 0;
        for (int i = 0; i < arr.size() - 1; ++i) {
            if (arr[i] % 2 == 1 && b % 2 == 1) odd_count++;
        }
        if (arr[k - 1] % 2 == 1) odd_count++;
        cout << ((odd_count % 2 == 1) ? "odd" : "even") << endl;
    }
};
