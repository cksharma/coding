#include <bits/stdc++.h>
using namespace std;

class APawnChess {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        string row; int white = INT_MAX, black = INT_MAX;
        vector<string> rows(8);
        for(int i = 0; i < 8; ++i) cin >> rows[i];
        for(int i = 0; i < 8; ++i) {
            string row = rows[i];
            for(int k = 0; k < 8; ++k) {
                char ch = row[k];
                if (ch == 'W') {
                    bool ok = true;
                    for (int j = i - 1; ok && j >= 0; --j)
                        ok = ok & (rows[j][k] == '.');
                    if (ok)
                        white = min(white, i);
                }

                if (ch == 'B') {
                    bool ok = true;
                    for (int j = i + 1; ok && j < 8; ++j)
                        ok = ok & (rows[j][k] == '.');
                    if (ok)
                        black = min(black, 7 - i);
                }
            }
        }
        cout << (white <= black ? "A" : "B") << endl;
    }
};
