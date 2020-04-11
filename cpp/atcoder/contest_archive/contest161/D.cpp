#include <bits/stdc++.h>
using namespace std;
using ll = long long;

bool valid(ll num) {
    ll pd = num % 10;
    while (num > 0) {
        ll md = num % 10;
        if (abs(pd - md) > 1) return false;
        pd = md;
        num /= 10;
    }
    return true;
}

ll reverse(ll num) {
    ll ans = 0; ll factor = 1;
    while (num > 0) {
        ll d = num % 10;
        ans = ans * factor + d;
        factor *= 10;
        num /= 10;    
    }
    return ans;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int K;
    cin >> K;
    
    ll seed = 0;
    while (K-- > 0) {
        if (valid(seed + 1)) {
            seed = seed + 1;
        } else {
            seed = reverse(seed);
        }
        cout << seed << " ";
    }
    cout << seed << endl;
}
