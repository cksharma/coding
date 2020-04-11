#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

    long long n, m; cin >> n >> m;
    long long ans = 0;

    for(long long i = 1; i <= min(1000LL, n); i++) {
        for(long long j = 1; j <= min(1000LL, n); j++) {
            long long sum = i * i + j * j;
            if(sum % m == 0) ans++;
        }
    }

    if( n > 1000 ) {
        ans = (n / m ) * ( n / m );
    }

    cout << ans << endl;
    return 0;
}