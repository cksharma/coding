#include <bits/stdc++.h>
using namespace std;

void getFactors(set<int>& set, int n) {
    for(int i = 1; i * i <= n; ++i) {
        if( n % i == 0 ) {
            set.insert( { i, n / i });
        }
    }
}

int main()
{
    int n, k;
    cin >> n >> k;

    set<int> factors;
    getFactors( factors, n );

    int ans = INT_MAX;
    for(int item : factors) {
        int a = item;
        int b = n / a;

        if( b < k ) {
            ans = min( ans, a * k + b );
        }
        if( a < k ) {
            ans = min( ans, b * k + a );
        }
    }
    cout << ans << endl;
}

