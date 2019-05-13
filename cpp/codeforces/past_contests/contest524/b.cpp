#include <bits/stdc++.h>
using namespace std;

int main()
{
    int q; cin >> q;
    for(int i = 0; i < q; ++i) {
        long long l, r, ans = 0;
        cin >> l >> r;
        if( l == r ) {
            ans = r % 2 == 0 ? r : -1* r;
        } else {
            long long oddStart = l % 2 == 1 ? l : l + 1;
            long long oddEnd = r % 2 == 1 ? r : r - 1;
            long long n = (oddEnd - oddStart) / 2 + 1;
            ans = ( n * ( oddStart + oddEnd ) ) / 2 * -1; 
            
            long long evenStart = l % 2 == 0 ? l : l + 1;
            long long evenEnd = r % 2 == 0 ? r : r - 1;
            n = ( evenEnd - evenStart ) / 2 + 1;
            ans += n * (evenStart + evenEnd ) / 2;
        }
        cout << ans << endl;
    }
    return 0;
}