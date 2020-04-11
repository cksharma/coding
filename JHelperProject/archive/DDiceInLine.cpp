#include <bits/stdc++.h>
using namespace std;

class DDiceInLine {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int N, K;
        cin >> N >> K;
        vector<int> v(N);
        for (int i = 0; i < N; ++i) cin >> v[i];

        double sum = 0, ans = 0;
        for (int i = 0; i < K; ++i) {
            sum += (v[i] + 1.) / 2.;
            ans = sum;
        }

        for (int i = K; i < N; ++i) {
            int left = i - K;
            sum -= (v[left] + 1.) / 2.;
            sum += (v[i] + 1.) / 2.;
            ans = max(ans, sum);
        }
        cout << ans << endl;
    }
};
