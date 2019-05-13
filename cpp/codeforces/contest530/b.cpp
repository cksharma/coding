#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    long long n; cin >> n;
    long long ans = 1LL + floor( sqrt(4LL * n - 3L ) );
    cout << ans << endl;
}
