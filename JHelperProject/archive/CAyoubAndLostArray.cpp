#include <bits/stdc++.h>
using namespace std;

const int N = 2 * 1e5 + 1;
long long dp[N][3];
int cnt[3];

class CAyoubAndLostArray {
public:
    static constexpr int md = 1000000007;

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, l, r; cin >> n >> l >> r;

        fill(cnt, cnt + 3, 0);
        for (int i = 0; i < N; ++i) fill(dp[i], dp[i] + 3, 0);

        int rem = l % 3;
        if (rem == 0) {
            cnt[0] = (r - l + 3) / 3;
            cnt[1] = (r - l + 2) / 3;
            cnt[2] = (r - l + 1) / 3;
        } else if (rem == 1) {
            cnt[1] = (r - l + 3) / 3;
            cnt[2] = (r - l + 2) / 3;
            cnt[0] = (r - l + 1) / 3;
        } else {
            cnt[2] = (r - l + 3) / 3;
            cnt[0] = (r - l + 2) / 3;
            cnt[1] = (r - l + 1) / 3;
        }

        dp[1][0] = cnt[0]; dp[1][1] = cnt[1]; dp[1][2] = cnt[2];

        for (int i = 2; i <= n; ++i) {
            dp[i][0] = (dp[i - 1][0] * cnt[0]) % md + (dp[i - 1][1] * cnt[2]) % md + (dp[i - 1][2] * cnt[1]) % md;
            dp[i][0] %= md;

            dp[i][1] = (dp[i - 1][0] * cnt[1]) % md + (dp[i - 1][1] * cnt[0]) % md + (dp[i - 1][2] * cnt[2]) % md;
            dp[i][1] %= md;

            dp[i][2] = (dp[i - 1][0] * cnt[2]) % md + (dp[i - 1][1] * cnt[1]) % md + (dp[i - 1][2] * cnt[0]) % md;
            dp[i][2] %= md;
        }
        cout << dp[n][0] << endl;
    }
};
