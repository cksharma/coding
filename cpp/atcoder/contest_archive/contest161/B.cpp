#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N, M;
    cin >> N >> M;
    vector<int> v(N); int sum = 0;
    for (int i = 0; i < N; ++i) {
        cin >> v[i];
        sum += v[i];
    }
    
    int s = 0;
    for (int i = 0; i < N && s < M; ++i) {
        if (v[i] * 4 * M >= sum) s++;
    }
    if (s == M) cout << "Yes" << endl;
    else cout << "No" << endl;
}
