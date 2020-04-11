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
    
    ll N, A, B;
    cin >> N >> A >> B;
    ll factor = N / ( A + B);
    ll mod = N % (A + B);
    
    ll ans = factor * A + min(mod, A);
    cout << ans << endl;
}