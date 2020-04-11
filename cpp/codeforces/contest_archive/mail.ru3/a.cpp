#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    map<int, int> mp;
    for(int i = 0; i < n; ++i) {
        int r; cin >> r;
        for(int j = 0; j < r; ++j) {
            int t; cin >> t;
            mp[t]++;
        }
    }
    for(auto& p : mp) {
        if( p.second == n ) cout << p.first << " ";
    }
    cout << "\n";
    return 0;
}