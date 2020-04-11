#include <bits/stdc++.h>
using namespace std;

class BBuildAContest {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, m; cin >> n >> m;
        vector<int> arr(m);
        for (int i = 0; i < m; ++i) {
            cin >> arr[i];
        }

        map<int, int> mp;
        for (int i = 0; i < arr.size(); ++i) {
            mp[arr[i]]++;
            if(mp.size() == n) {
                cout << '1';
                vector<map<int, int>::iterator> del;
                for (auto it = mp.begin(); it != mp.end(); ++it) {
                    if (it->second == 1) {
                        del.push_back(it);
                    } else {
                        mp[it->first] = it->second - 1;
                    }
                }
                for (auto it : del) {
                    mp.erase(it);
                }
            } else {
                cout << '0';
            }
        }
        cout << endl;
    }
};
