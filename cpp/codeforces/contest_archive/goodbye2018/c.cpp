#include <bits/stdc++.h>
using namespace std;

set<int> getFactors(int n) {
    set<int> result;
    for(int i = 1; i * i <= n; ++i) {
        if( n % i == 0 ) {
            result.insert( { i, n / i });
        }
    }
    return result;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    int n; cin >> n;
    set<int> factors = getFactors(n);

    set<long long> ans;
    for( long long d : factors ) {
        long long a = 1;
        long long n1 = n / d;
        long long sum = n1 * ( 2 * a + (n1 - 1) * d ) / 2;
        ans.insert(sum);
    }
    for(long long fun : ans ) {
        cout << fun << " ";
    }
    cout << "\n";
}
