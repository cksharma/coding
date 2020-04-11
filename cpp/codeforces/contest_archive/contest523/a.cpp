#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, S;
    cin >> n >> S;
    int ans = 0, coin = n;

    while(S > 0 && S > n) {
        ans += S / n;
        S = S - ( S / n ) * n;
    }

    if( S > 0) ans++;
    cout << ans << endl;

    return 0;
}