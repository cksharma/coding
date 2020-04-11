#include <bits/stdc++.h>
#define long long long
using namespace std;

const int SIZE = 1000;
int N, H;
int dp[SIZE];
vector<pair<int, int>> v;

int solve()
{
    int ans = 0;
    while (H > 0) {
        int idx = -1, best = INT_MAX;
        for (int i = 0; i < v.size(); ++i) {
            int c = floor(1. * H / v[i].first);
            if (c == 0) c = 1;
            if (c * v[i].second < best) {
                best = c * v[i].second;
                idx = i;
            }
        }

        int f = floor(1. * H / v[idx].first);
        if (f == 0) f = 1;
        H -= f * v[idx].first;
        ans += f * v[idx].second;

    }
    return ans;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    cin >> H >> N; int a, b;
    for (int i = 0; i < N; ++i) {
        cin >> a >> b;
        v.emplace_back(a, b);
    }
    cout << solve() << endl;
}
