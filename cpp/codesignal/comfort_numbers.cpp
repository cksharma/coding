#include <bits/stdc++.h>
using namespace std;

int comfortableNumbers(int l, int r) {
    int ans = 0;
    auto sum = [](int n) {
        int ss = 0;
        while (n > 0) {
            ss += (n % 10);
            n /= 10;
        }
        return ss;
    };
    for (int i = l; i < r; ++i) {
        int to = i + sum(i);
        to = min(to, r);
        ans += (to - i);
    }
    return ans;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    cout << comfortableNumbers(12, 108) << endl;
}
