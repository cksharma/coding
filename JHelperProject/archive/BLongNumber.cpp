#include <bits/stdc++.h>
using namespace std;

class BLongNumber {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        string input; cin >> input;
        int mp[10]; fill(mp, mp + 10, 0);
        for (int i = 1; i <= 9; ++i) cin >> mp[i];

        bool flag = false;
        for (int i = 0; i < input.size(); ++i) {
            int d = input[i] - '0';
            if (mp[d] > d || (mp[d] == d and flag)) {
                input[i] = '0' + mp[d];
                flag = true;
            } else if (flag == true){
                break;
            }
        }
        cout << input << endl;
    }
};