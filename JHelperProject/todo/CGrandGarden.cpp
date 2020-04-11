#include <bits/stdc++.h>
using namespace std;

class CGrandGarden {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n; cin >> n;
        vector<int> arr(n);
        for (int& a : arr) cin >> a;

        int ans = 0;
        list<vector<int>> V; V.push_back(arr);
        while (V.size() > 0) {
            const vector<int>& v = V.front();
            int min = *min_element(v.begin(), v.end());
            vector<int> temp;
            for (int j = 0; j < v.size(); ++j) {
                if(v[j] != min) {
                    temp.push_back(v[j] - min);
                } else if(temp.size() > 0) {
                    V.push_back(temp);
                    temp.clear();
                }
            }
            if (temp.size() > 0) V.push_back(temp);
            ans += min;
            V.pop_front();
        }
        cout << ans << endl;
    }
};
