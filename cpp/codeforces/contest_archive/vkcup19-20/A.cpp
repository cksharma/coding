#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    int t, r, c, x, y;
    cin >> t;
    while (t-- > 0) {
        cin >> r >> c >> x >> y;
        int a1 =  x * c;
        int a2 = (r - x - 1) * c;
        
        int a3 = y * r;
        int a4 = (c - y - 1) * r;
        
        int ans = max( max(a1, a2), max(a3, a4) );
        cout << ans << endl;
    }    
}
