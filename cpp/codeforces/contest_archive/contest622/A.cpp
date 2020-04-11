#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t-- > 0) {
        int a, b, c; int ans = 0;
        cin >> a >> b >> c;
        vector<int> v {a, b, c};
        sort(v.rbegin(), v.rend());
        a = v[0]; b = v[1]; c = v[2];
        
        if (a > 0) { ans++; a--; }
        if (b > 0) { ans++; b--; }
        if (c > 0) { ans++; c--; }
        
        if (a > 0 && b > 0) { ans++; a--; b--;}
        if (c > 0 && a > 0) { ans++; c--; a--;}
        if (b > 0 && c > 0) { ans++; b--; c--;}
        
        if (a > 0 && b > 0 && c > 0) {ans++;}
        cout << ans << endl;
    }
}