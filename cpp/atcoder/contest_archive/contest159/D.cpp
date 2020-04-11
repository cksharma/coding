#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N; cin >> N;
    vector<int> A(N);
    for (int i = 0; i < N; ++i) cin >> A[i];
    
    ll sum = 0;
    unordered_map<int, int> cntMap;
    for (int i = 0; i < N; ++i) {
        cntMap[A[i]]++;
    }
    for (const auto& p : cntMap) {
        int cnt = p.second;
        sum += (ll)((cnt - 1LL) * cnt) / 2;
    }
    for (int item : A) {
        cout << sum - (cntMap[item] - 1) << endl;
    }
}
