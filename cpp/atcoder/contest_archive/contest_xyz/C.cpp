#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    int N, K;
    cin >> N >> K;
    vector<int> h(N);
    for (int i = 0; i < N; ++i) {
        cin >> h[i];
    }
    sort(h.rbegin(), h.rend());
    long long ans = 0LL;
    for (int i = K; i < h.size(); ++i) {
        ans += (long long)h[i];
    }
    cout << ans << endl;
}
