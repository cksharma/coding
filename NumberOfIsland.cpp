#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numIslands(vector<string>& grid) {
        if (grid.size() == 0) return 0;
        int n = grid.size();
        int m = grid[0].size();
        
        bool visited[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) visited[i][j] = false;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    queue<pair<int, int>> Q;
                    Q.push(make_pair(i, j));
                    ans++;

                    while (Q.size() > 0) {
                        pair<int, int> P = Q.front();
                        Q.pop();
                        int x = P.first;
                        int y = P.second;    
                        visited[x][y] = true;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1' && visited[x - 1][y] == false) {
                            //visited[x - 1][y] = true;
                            Q.push(make_pair(x - 1, y));
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1' && visited[x][y - 1] == false) {
                            //visited[x][y - 1] = true;
                            Q.push(make_pair(x, y - 1));
                        }
                        if (x + 1 < n && grid[x + 1][y] == '1' && visited[x + 1][y] == false) {
                            //visited[x + 1][y] = true;
                            Q.push(make_pair(x + 1, y));
                        }
                        if (y + 1 < m && grid[x][y + 1] == '1' && visited[x][y + 1] == false) {
                            //visited[x][y + 1] = true;
                            Q.push(make_pair(x, y + 1));
                        }                                         
                    }                   
                }
            }
        }
        return ans;
            
    }
};

int main() {
    //vector<char> v = {'1'};
    //vector<vector<char>> vect;
    //vect.push_back(v);


    //vector<string> vect = { "11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
    vector<string> vect = { "11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111"};
    //vect = {"111","010","010"};
    Solution sol;
    cout << "No of Islands = " << sol.numIslands(vect) << endl;
}