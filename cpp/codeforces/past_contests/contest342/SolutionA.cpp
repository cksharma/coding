#include <bits/stdc++.h>
using namespace std;
#define LL long long

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    LL n, a, b, c;
    cin >> n >> a >> b >> c;
    LL ans1 = n / a;
    LL ans2 = n - c <= 0 ? 0 : (n - c) / (b - c);
    if (ans2 != 0) {
        LL temp = (n - (b * ans2 - c * ans2));
        temp /= a;
        ans2 = ans2 + temp;
    }
    cout << max(ans1, ans2) << endl;
}
