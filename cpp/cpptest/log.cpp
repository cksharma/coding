#include <bits/stdc++.h>
using namespace std;
int findMaxLength(vector<int>& nums) {
    vector<int> A(nums.size() + 1, 0);
    for_each(nums.begin(), nums.end(), [](int& item) { if (item == 0) item = -1; });
    for (int i = 0; i < nums.size(); ++i) {
        A[i + 1] = A[i] + nums[i];
    }

    unordered_map<int, int> mp; int sum = 0;
    for (int i = 0; i < A.size(); ++i) mp[A[i]] = i;

    int ans = 0;
    for (int i = 0; i < A.size(); ++i) {
        int sum = A[i - 1];
        int need = sum;
        auto it = mp.find(need);
        if (it != mp.end()) {
            int idx = it->second;
            ans = max(ans, idx - i + 1);
        }
    }
    return ans;
}

void recurse(vector<string>& v, unordered_set<pair<string, string>>& visited,
             const string& source, const unordered_map<string, set<string>>& graph)
{
    v.push_back(source);
    if (graph.find(source) == graph.end()) return;
    const set<string>& neighbours = graph[source];

    for (const string& neighbour : neighbours) {
        pair<string, string> p = make_pair(source, neighbour);
        if (visited.find(p) == visited.end()) {
            recurse(v,visited, neighbour, graph);
        }
    }
}

vector<string> findItinerary(vector<pair<string, string>> tickets) {
    vector<string> v;
    unordered_map<string, set<string>> graph;
    for (auto& p : tickets) {
        graph[p.first].insert(p.second);
    }
    unordered_set<pair<string, string>> visited;
    recurse(v, visited, "JFK", graph);
    return v;
}

int main() {

}