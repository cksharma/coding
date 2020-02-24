#include <bits/stdc++.h>
using namespace std;

class TaskA {
public:
	void solve(std::istream& cin, std::ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int t, n; cin >> t;
        while (t-- > 0) {
            cin >> n;
            vector<int> v(n);
            for (int i = 0; i < n; ++i) {
                cin >> v[i];
            }
            int zero = count_if(v.begin(), v.end(), [](int item) { return item == 0; });
            int pos = count_if(v.begin(), v.end(), [](int item) { return item > 0; });
            int neg = count_if(v.begin(), v.end(), [](int item) { return item < 0; });
            int sum = accumulate(v.begin(), v.end(), 0);

            int ans = zero;
            sum += zero;
            if (sum == 0) ans++;
            cout << ans << endl;
        }
	}
};
