#include <bits/stdc++.h>
using namespace std;
#define LL long long

void solve(LL num, int n, int& res) {
    if (num <= n) res++;
    else return;
    solve(num * 10, n, res);
    solve(num * 10 + 1, n, res);
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    int res = 0;
    solve(1LL, n, res);
    cout << res << endl;
}