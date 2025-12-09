#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

long long solve_linear(vector<long long>& a) {
    int n = a.size();
    if (n == 1) return 0;
    if (n == 2) return max(a[0], a[1]);
    
    // Precompute max for all ranges
    vector<vector<long long>> mx(n, vector<long long>(n));
    for (int i = 0; i < n; ++i) {
        mx[i][i] = a[i];
        for (int j = i + 1; j < n; ++j) {
            mx[i][j] = max(mx[i][j-1], a[j]);
        }
    }
    
    // dp[i][j] = min cost to merge [i, j]
    vector<vector<long long>> dp(n, vector<long long>(n, 0));
    
    for (int len = 2; len <= n; ++len) {
        for (int i = 0; i + len - 1 < n; ++i) {
            int j = i + len - 1;
            dp[i][j] = 1e18;
            
            for (int k = i; k < j; ++k) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + mx[i][j]);
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
    
    // Find max element
    long long max_val = *max_element(a.begin(), a.end());
    long long ans = 1e18;
    
    // Only try breaking at positions adjacent to max elements
    for (int i = 0; i < n; ++i) {
        if (a[i] == max_val) {
            // Try breaking before and after this max element
            for (int delta = 0; delta <= 1; ++delta) {
                int break_pos = (i + delta) % n;
                vector<long long> b;
                for (int j = 0; j < n; ++j) {
                    b.push_back(a[(break_pos + j) % n]);
                }
                ans = min(ans, solve_linear(b));
            }
        }
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
