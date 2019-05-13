#include <bits/stdc++.h>
using namespace std;

int main()
{
    long long n, k;
    cin >> n >> k;
    
    long long red = 2 * n;
    long long green = 5 * n;
    long long blue = 8 * n;
    
    long long ans = (long long)ceil( 1. * red / k );
    ans += (long long) ceil( 1.* green / k );
    ans += (long long) ceil( 1.* blue / k );
    
    cout << ans << endl;
    
    return 0;
}