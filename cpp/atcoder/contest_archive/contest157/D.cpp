#include <bits/stdc++.h>
using namespace std;

const int C = (int)1e5 + 1;
int N, M, K;

vector<int> graph(C, -1);

vector<vector<int>> g_frens(C);
vector<vector<int>> g_block(C);

int root(int n) {
    return graph[n] == -1 ? n : root(graph[n]);
}

void merge(int a, int b) {
    int root1 = root(a);
    int root2 = root(b);
    if (root1 == root2) return;
    if (root1 > root2) graph[root1] = root2;
    else graph[root2] = root1;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr); 
    
    cin >> N >> M >> K;
    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;
        g_frens[a].push_back(b);
        g_frens[b].push_back(a);
        merge(a, b);
    }
    for (int i = 0; i < K; ++i) {
        int c, d;
        cin >> c >> d;
        g_block[c].push_back(d);
        g_block[d].push_back(c);
    }

    int cntArr[N + 1];
    fill(cntArr, cntArr + N + 1, 0);
    for (int i = 1; i <= N; ++i) {
        int r = root(i);
        cntArr[r]++;
    }
    
    for (int i = 1; i <= N; ++i) {
        int r1 = root(i);
        int cnt = cntArr[r1] - g_frens[i].size() - 1;
        for (int j = 0; j < g_block[i].size(); ++j) {
            int r2 = root(g_block[i][j]);
            if (r1 == r2) cnt--;
        }
        cout << cnt << " ";
    }
}
