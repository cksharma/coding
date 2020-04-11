#include <bits/stdc++.h>
using namespace std;

int dp[401][401];

class CAlternatingPath {
public:

    void printdp(int H, int W) {
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                cout << dp[i][j] << " ";
            }
            cout << endl;
        }
    }

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int H, W; cin >> H >> W;
        vector<string> v(H);
        for (int i = 0; i < H; ++i) cin >> v[i];

        for (int i = 0; i < H; ++i) fill(dp[i], dp[i] + W, 0);
        for (int j = 1; j < v[0].size(); ++j) if (v[0][j - 1] != v[0][j]) dp[0][j] = 1;
        for (int i = 1; i < H; ++i) if (v[i - 1][0] != v[i][0]) dp[i][0] = 1;

        for (int i = 1; i < H; ++i) {
            for (int j = 1; j < W; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (v[i - 1][j] != v[i][j]) {
                    dp[i][j] += 1;
                }
                if (v[i][j - 1] != v[i][j]) {
                    dp[i][j] += 1;
                }
            }
        }
        //printdp(H, W);
        cout << dp[H - 1][W - 1] << endl;
    }
};
