#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int t; cin >> t;
    while(t-- > 0) {
        int n; cin >> n;
        vector<int> v(n, -1);
        string ans = "NO";
        for (int i = 0; i < n; ++i) {
            int a; cin >> a; a--;
            if (v[a] != -1 && i - v[a] > 1) ans = "YES";
            if (v[a] == -1) v[a] = i;
        }
        cout << ans << endl;
    }
}
