#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int w, h; cin >> w >> h;
    int u1, d1; cin >> u1 >> d1;
    int u2, d2; cin >> u2 >> d2;

    if( d2 > d1 ) {
        swap( d1, d2 );
        swap( u1, u2 );
    }

    while( h > 0 ) {
        w += h;
        if( h == d1 ) w -= u1;
        else if ( h == d2 ) w -= u2;
        w = max( w, 0 );
        h--;
    }
    cout << w << endl;
}
