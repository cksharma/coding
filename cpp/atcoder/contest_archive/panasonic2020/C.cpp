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
    
    ll a, b, c;
    cin >> a >> b >> c;
    
    ll lhs = 4 * a * b;
    ll rhs = (c - a - b) * (c - a - b);
    if (c - a - b < 0) {
        cout << "No" << endl;
    }
    else 
        cout << (lhs < rhs ? "Yes" : "No") << endl;
}
