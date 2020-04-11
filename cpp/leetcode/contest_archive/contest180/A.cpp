#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        
        vector<int> result;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                int elem = matrix[r][c];
                
                int min_row = INT_MAX;
                for (int j = 0; j < m; ++j) {
                    min_row = min(min_row, matrix[r][j]);
                }
                
                int max_col = INT_MIN;
                for (int i = 0; i < n; ++i) {
                    max_col = max(max_col, matrix[i][c]);
                }
                if (min_row == elem && max_col == elem) result.push_back(elem);
            }
        }
        return result;
    }
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);   
}
