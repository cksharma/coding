#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

long long solve_linear(vector<long long>& a) {
    int n = a.size();
    if (n == 1) return 0;
    if (n == 2) return max(a[0], a[1]);
    
    // dp[i][j] = min cost to merge [i, j]
    vector<vector<long long>> dp(n, vector<long long>(n, 0));
    
    // For each length
    for (int len = 2; len <= n; ++len) {
        for (int i = 0; i + len - 1 < n; ++i) {
            int j = i + len - 1;
            dp[i][j] = 1e18;
            
            // Find max in range [i, j]
            long long mx = 0;
            for (int k = i; k <= j; ++k) {
                mx = max(mx, a[k]);
            }
            
            // Try all split points
            for (int k = i; k < j; ++k) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + mx);
            }
        }
    }
    
    return dp[0][n-1];
}

void solve() {
    int n;
    cin >> n;
    vector<long long> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    
    if (n == 1) {
        cout << 0 << endl;
        return;
    }
    
    if (n == 2) {
        cout << max(a[0], a[1]) << endl;
        return;
    }
    
    long long ans = 1e18;
    
    // Try breaking between each adjacent pair
    for (int i = 0; i < n; ++i) {
        vector<long long> b;
        for (int j = 0; j < n; ++j) {
            b.push_back(a[(i + j) % n]);
        }
        ans = min(ans, solve_linear(b));
    }
    
    cout << ans << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
