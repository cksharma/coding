#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll N, K;
    cin >> N >> K;
    if (N >= K) {
        ll mod = N % K;
        ll mod1 = K - mod;
        cout << min(mod, mod1) << endl;
    } else {
        int steps = 100000; 
        ll ans = LONG_MAX;
        while (steps--) {
            ans = min(ans, abs(N - K));
            N = abs(N - K);
        }
        cout << ans << endl;
    }
}
