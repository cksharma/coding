#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int n; cin >> n;
    vector<int> a(n);
    vector<int> b(n);
    for (int i = 0; i < n; ++i) cin >> a[i];
    for (int i = 0; i < n; ++i) cin >> b[i];
    vector<int> d(n);
    for (int i = 0; i < n; ++i) d[i] = a[i] - b[i];
    sort(d.rbegin(), d.rend());
    ll ans = 0LL;
    
    int i = 0, j = d.size() - 1;
    while (i < j) {
        if (d[i] + d[j] > 0) {
            ans += (ll)(j - i);
            ++i;
        } else {
            --j;
        }
    }
    cout << ans << endl;
}
