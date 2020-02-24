#include <bits/stdc++.h>
using namespace std;

int countSumOfTwoRepresentations2(int n, int l, int r) {
    int ans = 0;
    if (2 * l <= n && 2 * r >= n) {
        int hi = min(r, n), lo = max(n - r, l);

        int hic = n - hi; int loc = n - lo;
        if (hic >= l) ans += (hi - hic + 1) / 2;
        else if (loc <= r) ans += (loc - lo + 1) / 2;
        if (n % 2 == 0) ans++;
    }
    return ans;
}


int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    cout << countSumOfTwoRepresentations2(6, 2, 4) << endl;
    cout << countSumOfTwoRepresentations2(93, 24, 58) << endl;
}
