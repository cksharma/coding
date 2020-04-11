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
    int H, W;
    cin >> H >> W;
    vector<string> grid(H);
    for (int i = 0; i < H; ++i) {
        cin >> grid[i];
    }
    
    int dp[H][W];
    for (int i = 0; i < H; ++i) for (int j = 0; j < W; ++j) dp[i][j] = INF;
    dp[0][0] = cost(grid[0][0]);
    
    for (int i = 0; i < H; ++i) {
        for (int j = 0; j < W; ++j) {
            if (i == 0 && j == 0) continue;
            if (i - 1 >= 0) dp[i][j] = min(dp[i][j], dp[i - 1][j] + cost(grid[i][j]));
            if (j - 1 >= 0) dp[i][j] = min(dp[i][j], dp[i][j - 1] + cost(grid[i][j]));
        }
    }
    cout << dp[H - 1][W - 1] << endl;
}