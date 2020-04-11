#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    ll u, v;
    cin >> u >> v;
    if (u > v || (v - u) % 2 == 1) {
        cout << -1 << endl;
        return 0;
    }
    if (u == v && u == 0) {
        cout << 0 << endl;
        return 0;
    }
    if (u == v) {
        cout << 1 << endl;
        cout << u << endl;
        return 0;
    }
    ll p = (v - u) / 2;
    ll q = u ^ p;
    if (p + q == v) {
        cout << 2 << endl;
        cout << p << " " << q << endl;
        return 0;
    }
    cout << 3 << endl;
    cout << u << " " << p << " " << p << endl;
}
