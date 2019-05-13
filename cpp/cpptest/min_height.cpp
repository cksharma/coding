#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    map<int, int> memo;
    set<pair<int, int>> visited;
    map<int, set<int>> graph;

    int solve(int start, set<int>& running) {
        const set<int>& neighbours = graph[start];
        int val = 0;
        if (memo[start] != 0) return memo[start];
        for (int neighbour : neighbours) {
            pair<int, int> p = make_pair(start, neighbour);
            if (visited.find(p) != visited.end()) continue;
            visited.insert(p);
            running.insert(start); running.insert(neighbour);
            val = max(val, 1 + solve(neighbour, running));
            //visited.erase(p);
        }
        return memo[start] = val;
    }

    vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
        memo.clear();
        graph.clear();
        visited.clear();

        for (auto& p : edges) {
            graph[p.first].insert(p.second);
            graph[p.second].insert(p.first);
        }

        set<int> running;
        solve(0, running);

        int min_depth = INT_MAX;
        for (auto [key, val] : memo) {
            min_depth = min(val, min_depth);
        }
        vector<int> ans;
        for (auto [key, val] : memo) {
            if (val == min_depth) ans.push_back(key);
        }
        return ans;
    }
};
int main()
{
    Solution sol;
    vector<pair<int, int>> v;
    v.emplace_back(1, 0);v.emplace_back(1, 2);v.emplace_back(1, 3);
    vector <int> ans = sol.findMinHeightTrees(4, v);
    for (auto item : ans) cout << item << ", ";
}
