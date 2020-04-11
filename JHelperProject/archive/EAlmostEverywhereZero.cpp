#include <bits/stdc++.h>
using namespace std;

class EAlmostEverywhereZero {
public:

    long long dp[101][4];
    long long nCr(int n, int r) {
        if (n == r) return dp[n][r] = 1;
        if (r == 0) return dp[n][r] = 1;
        if (r == 1) return dp[n][r] = (long long) n;
        if (dp[n][r] > 0) return dp[n][r];
        return dp[n][r] = nCr(n - 1, r) + nCr(n - 1, r - 1);
    }

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        for (int i = 0; i < 101; ++i) fill(dp[i], dp[i] + 4, 0);

        string s; int k; cin >> s >> k; int n = s.size();
        nCr(n, k);
        long long ans = 0;

        //Special case. ( first 3 )
        long long prod = 1;
        for (int i = 0; i < k; ++i) prod *= (s[i] - '0');
        ans += prod;

        prod = 1;
        for (int i = 0; i < k - 1; ++i) {
            prod *= (s[i] - '0');
        }
        ans += prod + (n - k - 1) * 9;

        if (k == 3) {
            int d1 = s[0] - '0', d3 = s[2] - '0';
            prod = d1 * 9 * (n - k - 1) * 9;
        }
        ans += prod;
        ans += nCr(n - 1, k) * pow(9, k);
        cout << ans << endl;
    }
};
