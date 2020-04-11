#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 1;
vector<vector<int>> graph(N);
vector<int> label(N);

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int n; cin >> n;
    vector<pair<int, int>> vpii;
    for (int i = 0; i < n - 1; ++i) {
        int u, v; cin >> u >> v;
        vpii.emplace_back(u, v);
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    int index = 0;
    for (int i = 0; i < vpii.size(); ++i) {
        pair<int, int> p =  vpii[i];
        int u = p.first;
        int v = p.second;
        if (graph[u].size() == 1 || graph[v].size() == 1) {
            label[i] = index++;
            //cout << "CKS <" << label[i] << ">, ";
        }
    }
    for (int i = 0; i < vpii.size(); ++i) {
        pair<int, int> p = vpii[i];
        int u = p.first;
        int v = p.second;
        if (graph[u].size() == 1 || graph[v].size() == 1) continue;
        label[i] = index++;
    }
    for (int i = 0; i < vpii.size(); ++i) {
        cout << label[i] << "\n";        
    }
}
