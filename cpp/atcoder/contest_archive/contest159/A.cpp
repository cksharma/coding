#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N, M;
    cin >> N >> M;
    int ans = ((N - 1) * N) / 2;
    ans += ((M - 1) * M) / 2;
    cout << ans << endl;
}
