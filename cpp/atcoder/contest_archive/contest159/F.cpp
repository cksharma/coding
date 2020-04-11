#include <bits/stdc++.h>
using namespace std;

using ll = long long;
const int md = 998244353;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N, S; cin >> N >> S;
    vector<int> A(N);
    for (int i = 0; i < N; ++i) cin >> A[i];
    
    int dp[N][N];
    for (int i = 0; i < N; ++i) fill(dp[i], dp[i] + N, 0);
    
    int start = 0, cur = 0;
    int sum = 0;
    while (cur < N) {
        if (A[cur] > sum) {
            sum = 0;
            cur++;
            start = cur;
            continue;
        }
        sum += A[cur];
        if (sum == S) {
            dp[start][cur] = 1;
            sum -= A[start];
            start++;
            cur++;
        } else if (sum > S) {
            sum -= A[start];
            start++;
            if (sum < 0) sum = 0;
        } else {
            sum += A[cur];
            cur++;
        }
    }
    
    map<pair<int, int>, ll> mp;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            mp[{i, j}] = 1;
        }
    }
    ll ans = 0;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            pair<int, int> p = {i, j};
            auto lo = mp.lower_bound(p);
            auto hi = mp.upper_bound(p);
            ans += distance( lo, hi);
            ans %= md;
            mp[p] = distance(lo, hi);
        }
    }
    cout << ans << endl;
}
