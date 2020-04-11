#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    int n, k;
    cin >> n >> k;

    vector<int> pow(31);
    pow[0] = 1;
    for(int i = 1; i < pow.size(); ++i) {
        pow[i] = pow[i - 1] * 2;
    }

    vector<int> result;
    for(int i = pow.size() - 1; i >= 0; --i) {
        if( pow[i] > n ) continue;

        while( i >= 0 && k >= 1 && pow[i] <= n && n - pow[i] >= k - 1 ) {
            result.push_back(pow[i]);
            n -= pow[i];
            k -= 1;
        }
    }
    if( n != 0 || k != 0) {
        cout << "NO" << endl;
    } else {
        cout << "YES" << endl;
        for(int i = result.size() - 1; i >= 0; --i) cout << result[i] << " ";
        cout << endl;
    }
}
