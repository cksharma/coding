#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    ll H, W;
    cin >> H >> W;
    
    if (H == 1 || W == 1) {
        cout << 1 << endl;   
    } else {
        ll total = H * W;
        if (total % 2 == 1) total++;
        cout << (total / 2LL) << endl;
    }
}
