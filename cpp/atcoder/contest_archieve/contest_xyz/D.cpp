#include <bits/stdc++.h>
#define long long long
using namespace std;

long recurse(long n)
{
    if (n <= 0) return 0L;
    if (n == 1) return 1L;
    return 1L + 2 * recurse(n / 2L);
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    long H; cin >> H;
    cout << recurse(H) << endl;
}
