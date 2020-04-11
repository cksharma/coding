#include <bits/stdc++.h>
using namespace std;

class ARomanAndBrowser {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, k; cin >> n >> k;
        vector<int> arr(n + 1);
        int social = 0, test = 0;
        for (int i = 1; i <= n; ++i) {
            cin >> arr[i];
            if( arr[i] == 1 ) test++;
            else social++;
        }
        int ans = INT_MIN;
        for(int b = 1; b <= n; ++b) {
            int sc = social, tt = test;
            for(int i = -110; i <= 110; ++i ) {
                int c = b + i * k;
                if(c >= 1 && c <= n) {
                    if( arr[c] == -1 ) {
                        sc--;
                    } else {
                        tt--;
                    }
                }
            }
            ans = max(ans, abs(sc - tt));
        }
        cout << ans << endl;
    }
};
