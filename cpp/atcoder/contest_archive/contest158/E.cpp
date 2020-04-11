#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void print(int rem, int ans, int factor, int cnt) {
    cout << "[ rem=" << rem << ", ans=" << ans << ", factor=" 
         << factor << ", mp[rem]=" << cnt << "]\n";
}

int main()
{
    int N, P; string S;
    cin >> N >> P >> S;
    ll ans = 0LL;
    if (P == 2 || P == 5) {
        for (int i = 0; i < S.size(); ++i) {
            if ((S[i] - '0') % P == 0) ans += i + 1;
        }
    }
    else {
        unordered_map<int, int> mp;
        mp[0]++;
        int rem = 0, factor = 1;
        for (int i = S.size() - 1; i >= 0; --i) {
            rem = (rem + (S[i] - '0') * factor) % P;
            ans += mp[rem];
            mp[rem]++;
            factor = (factor * 10) % P;
            print(rem, ans, factor, mp[rem]);
        }
    }
    cout << ans << endl;
}
