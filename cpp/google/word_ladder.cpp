#include <bits/stdc++.h>
using namespace std;

unordered_set<string> one_edit_distance(const string& word) {
    unordered_set<string> result;
    for (int i = 0; i < word.size(); ++i) {
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            string s = word;
            s[i] = ch;
            result.insert(s);
        }
    }
    result.erase(word);
    return result;
}

void solve(const string& start, const string& end, unordered_map<string, int>& visited,
           unordered_set<string>& unvisited, int& ans)
{
    if (start == end) {
        ans = min(ans, visited[start]);
    }

    unordered_set<string> words = one_edit_distance(start);
    for (auto it = words.begin(); it != words.end(); ++it) {
        if (visited.find(*it) != visited.end()) continue;
        if (unvisited.find(*it) == unvisited.end()) continue;
        visited[*it] = visited[start] + 1;
        solve(*it, end, visited, unvisited, ans);
    }
}


int ladderLength(string start, string end, vector<string> &dictV) {
    int ans = INT_MAX;
    unordered_map<string, int> visited; unordered_set<string> unvisited;
    visited[start] = 1;
    for (auto& word : dictV) unvisited.insert(word);
    solve(start, end, visited, unvisited, ans);
    return ans == INT_MAX ? 0 : ans;
}


int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    string start = "hit";
    string end = "cog";
    vector<string> dict = {"hot","dot","dog","lot","log"};
    ladderLength(start, end, dict);
}
