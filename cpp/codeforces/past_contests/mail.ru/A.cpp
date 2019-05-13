#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, s;
    cin >> n >> s; s--;
    vector<int> f(n);
    vector<int> r(n);

    for(int i = 0; i < n; ++i) cin >> f[i];
    for(int i = 0; i < n; ++i) cin >> r[i];

    if( f[0] == 0 ) {
        cout << "NO";
        return 0;
    }

    string ans = "NO";
    for(int i = 1; i < n; ++i) {
        if( i == s && f[i] == 1 ){ ans = "YES"; break; }
        if( i > s && f[i] == 1 && r[i] == 1 && r[s] == 1 ) { ans = "YES"; break; }
    }

    cout << ans << endl;
    return 0;
}