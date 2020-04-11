#include <bits/stdc++.h>
using namespace std;

const int INF = 1e5;

int cost(char val) {
    return val == '#' ? 1 : 0;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N;
    cin >> N;
    string s;
    cin >> s;

    int ans = abs(s[1] - s[0]);
    for (int i = 1; i + 1 < N; ++i) {
        int diff = abs(s[i + 1] - s[i]);
        ans = abs(ans - diff);
    }
    cout << ans << endl;
}