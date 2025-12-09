#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

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
    
    // Try breaking the ring at each position and solve as interval DP
    long long ans = 1e18;
    
    for (int break_pos = 0; break_pos < n; ++break_pos) {
        // Create linear array starting from break_pos
        vector<long long> b;
        for (int i = 0; i < n; ++i) {
            b.push_back(a[(break_pos + i) % n]);
        }
        
        // dp[i][j] = min cost to merge elements from i to j into one element
        vector<vector<long long>> dp(n, vector<long long>(n, 0));
        vector<vector<long long>> maxval(n, vector<long long>(n));
        
        // Initialize: maxval[i][j] = max element in range [i, j]
        for (int i = 0; i < n; ++i) {
            maxval[i][i] = b[i];
            for (int j = i + 1; j < n; ++j) {
                maxval[i][j] = max(maxval[i][j-1], b[j]);
            }
        }
        
        // DP: for each length
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                dp[i][j] = 1e18;
                
                // Try all split points
                for (int k = i; k < j; ++k) {
                    long long cost = dp[i][k] + dp[k+1][j] + maxval[i][j];
                    dp[i][j] = min(dp[i][j], cost);
                }
            }
        }
        
        ans = min(ans, dp[0][n-1]);
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
