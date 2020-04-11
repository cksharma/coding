#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int inRange(int value, int l, int r)
{
    return l <= value && value <= r ? 1 : 0;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int n, h, l, r;
    cin >> n >> h >> l >> r;
    vector<int> v(n);
    for (int i = 0; i < n; ++i) cin >> v[i];
    
    int dp[n + 1][h];
    for (int i = 0; i < h; ++i) dp[0][i] = 0;
    
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j < h; ++j) {
            int item = v[i - 1];
            
        }
    }
}
