#include <bits/stdc++.h>
using namespace std;

const int C = 1e5 + 1;

vector<vector<int>> frend_g(C);
vector<vector<int>> block_g(C);
vector<int> parent(C, -1);

int root(int num)
{
    return parent[num] == -1 ? num : parent[num] = root(parent[num]);
}

void merge(int a, int b) {
    int p1 = root(a);
    int p2 = root(b);
    if (p1 == p2) return;
    if (p1 > p2) parent[p1] = p2;
    else parent[p2] = p1;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    int N, M, K;
    cin >> N >> M >> K;
    
    for (int i = 0; i < M; ++i) {
        int a, b; cin >> a >> b;
        frend_g[a].push_back(b);
        frend_g[b].push_back(a);
        merge(a, b);    
    }
    for (int i = 0; i < K; ++i) {
        int c, d; cin >> c >> d;
        block_g[c].push_back(d);
        block_g[d].push_back(c);
    }
    int cnt[N + 1];
    fill(cnt, cnt + N + 1, 0);
    for (int i = 1; i <= N; ++i) {
        int p1 = root(i);
        cnt[p1]++;
    }
    for (int i = 1; i <= N; ++i) {
        int p1 = root(i);
        int ans = cnt[p1] - frend_g[i].size() - 1;
        for (int b : block_g[i]) {
            int p2 = root(b);
            if (p1 == p2) ans--;
        }
        cout << ans << " ";
    }
    cout << endl;
}
