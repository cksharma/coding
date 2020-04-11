#include <bits/stdc++.h>
using namespace std;

using pii = pair<int, int>;

bool rowsRearranging(std::vector<std::vector<int>> matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    vector<int> indices(n);

    vector<pii> v(n);
    for (int i = 0; i < n; ++i) {
        v[i] = {matrix[i][0], i};
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); ++i) { indices[i] = v[i].second; cout << indices[i] << ", "; }
    
    for (int col = 0; col < m; ++col) {
        int prev = matrix[indices[0]][col];
        for (int j = 1; j < n; ++j) {
            int cur = matrix[indices[j]][col];
            if (cur <= prev) return false;
            prev = cur;
        }
    }
    return true;
}

int main()
{
    
}