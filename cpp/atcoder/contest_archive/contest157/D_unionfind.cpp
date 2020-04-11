#include <bits/stdc++.h>
using namespace std;

const int C = (int)1e5 + 1;
int N, M, K;
vector<int> parent(C, -1);
vector<vector<int>> graph(C);
vector<vector<int>> block(C);

int root(int num) {
    return parent[num] == -1 ? num : parent[num] = root(parent[num]);
}

void merge(int a, int b) {
    int p1 = root(a);
    int p2 = root(b);
    if (p1 == p2) return;
    if (p1 < p2) parent[p2] = p1;
    else parent[p1] = p2;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    
    cin >> N >> M >> K;
    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
        merge(a, b);
    }
    for (int i = 0; i < K; ++i) {
        int c, d;
        cin >> c >> d;
        block[c].push_back(d);
        block[d].push_back(c);
    }
    int cnt[N + 1]; fill(cnt, cnt + N + 1, 0);
    for (int i = 1; i <= N; ++i) {
        int p = root(i);
        ++cnt[p];
        //cout << "[i=" << i << ", p=" << p << "], ";
    }
    for (int i = 1; i <= N; ++i) {
        int p1 = root(i);
        int count = cnt[p1] - graph[i].size() - 1; // Friends + myself from union
        for (int b : block[i]) {
            int p2 = root(b);
            if (p1 == p2) count--;
        }
        cout << count << " ";
    }
    cout << endl;
}   
