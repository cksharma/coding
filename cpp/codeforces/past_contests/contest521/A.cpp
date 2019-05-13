#include <bits/stdc++.h>
using namespace std;
int main()
{
    int t; cin >> t;
    long long a, b, k;
    while(t-- > 0) {
        cin >> a >> b >> k;
        cout << (a - b ) * (k / 2) +  ( k % 2 == 1 ? a : 0 ) << endl;
    }
    return 0;
}