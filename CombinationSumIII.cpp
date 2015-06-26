#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> vect;
    bool* visited;
    int n;
    
    void solve(vector<int>& v, int k, int index, int sum) {
        if (k < 0 || index >= n) return;
        if (sum + v[index] == n && k == 0) {
            v.push_back(v[index]);
            vect.push_back(v);
            v.clear();
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false && sum + i <= n) {
                visited[i] = true;
                v.push_back(i);
                solve(v, k - 1, index + 1, sum + i);
                visited[i] = false;
                v.erase(remove(v.begin(), v.end(), i), v.end());
            }
        }
    }
    
    vector<vector<int>> combinationSum3(int k, int n) {
        this->visited = new bool[n + 1];
        fill(visited, visited + n + 1, false);
        this->n = n;
        
        vector<int> v;
        solve(v, k, 0, 0);    
        return vect;
    }
};

int main() {
    Solution sol;
    vector<vector<int>> v = sol.combinationSum3(3, 2);
    for (auto& item : v) {
        for (auto& item1 : item) {
            cout << item1 << " ";
        }
        cout << endl;
    }
}