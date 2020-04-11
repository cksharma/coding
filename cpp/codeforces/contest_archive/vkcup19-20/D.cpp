#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    int n; cin >> n;
    map<int, vector<int>> mp;
    vector<int> a(n), t(n);
    for (int i = 0; i < n; ++i) cin >> a[i];
    for (int i = 0; i < n; ++i) cin >> t[i];
    
    for (int i = 0; i < n; ++i) {
        int ai = a[i];
        int ti = t[i];
        mp[ai].push_back(ti);
    }
       
    ll ans = 0LL;
    int num = -1;
    for (auto& [k,v] : mp) {
        if (v.size() == 1) continue;
        sort(v.begin(), v.end());
        
        num = max(k + 1, num);
        for (int i = 0; i < v.size() - 1; ++i) {
            while (mp.find(num) != mp.end()) ++num;
            ans += (ll)(num - k) * (ll)v[i];
            ++num;
        }
    }
    cout << ans << endl;
}
