#include <bits/stdc++.h>
using namespace std;

void dfs(int index, vector<pair<int, int>> &v, bool visited[]) {
    if (visited[index]) return;
    int x = v[index].first, y = v[index].second;
    visited[index] = true;
    for (int i = 0; i < v.size(); i++) {
        if (v[i].first == x || v[i].second == y) dfs(i, v, visited);    
    }
}

int main() {
    int n, x, y;
    scanf("%d", &n);
    vector<pair<int, int>> v;
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &x, &y);
        v.push_back(make_pair(x, y));
    }
    bool visited[n];
    fill(visited, visited + n, false);
    
    int ans = -1;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, v, visited);
            ans++;
        }
    }
    printf("%d\n", ans);
}