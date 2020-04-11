#include <bits/stdc++.h>
using namespace std;

const int INF = 1e5;

array<int, 4> dx = {-1, +0, +1, +0};
array<int, 4> dy = {+0, +1, +0, -1};

class Solution {
public:

    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        queue<tuple<int, int, int>> Q;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    Q.emplace(i, j, 0);
                }
            }
        }
        int ans = 0;
        while (not Q.empty()) {
            const auto& top = Q.front();
            int r = get<0>(top), c = get<1>(top), d = get<2>(top);
            Q.pop();
            ans = max(ans, d);
            for (int i = 0; i < dx.size(); ++i) {
                int x = dx[i] + r;
                int y = dy[i] + c;
                if (x >= 0 && x < n && y >=0 && y < m && grid[x][y] == 1) {
                    Q.emplace(x, y, d + 1);
                    grid[x][y] = 2;
                }
            }
        }
        for (int i = 0; i < n; ++i) for (int j = 0; j < m; ++j) if (grid[i][j] == 1) return -1;
        return ans;
    }
};

int main()
{
    vector<vector<int>> grid ={{2,1,1},{1,1,0},{0,1,1}};
    cout << Solution().orangesRotting(grid) << endl;
    
    grid = {{2,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,0,1,0,1},
            {1,0,1,0,0,1,0,1,0,1},
            {1,0,1,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}};
    cout << Solution().orangesRotting(grid) << endl;
}
