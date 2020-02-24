#include <bits/stdc++.h>
using namespace std;

int countBlackCells(int n, int m) {
    if (n == 1 || m == 1) return n * m;
    if (n == m) return 4 + (n - 2) * 3;
    int g = __gcd(n, m);
    int ans = n + m - g + (g - 1) * 2;
    /* n + m - g only takes the cells that are properly cut.
     * (g - 1)* 2 takes the cells that are touched at border only
    */
    return ans;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    cout << countBlackCells(33, 44) << endl;
}
