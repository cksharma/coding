#include <bits/stdc++.h>
#define LL long long

using namespace std;

int main() {
    LL k, n, w;
    scanf("%lld %lld %lld", &k, &n, &w);
    LL cost = 0;
    LL ans = 0;
    for (int i = 1; i <= w; i++) {
        cost += (i * k);
    }
    if (cost > n) ans = cost - n;
    printf("%lld", ans);

    return 0;
}