#include <bits/stdc++.h>
using namespace std;

class CMultiSubjectCompetition {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, m; cin >> n >> m;
        map< int, vector<int> > mp;

        int s, r, sz = 0;
        for(int i = 0; i < n; i++) {
            cin >> s >> r;
            mp[s].push_back(r);
            sz = max( sz, (int)mp[s].size());
        }
        map<int, int> sumMap;
        for(auto& [k, v] : mp ) {
            sort( v.rbegin(), v.rend() );
            int sum = 0;
            for(int i = 0; i < v.size(); ++i) {
                sum += v[i];
                if( sum <= 0 ) break;
                sumMap[i + 1] += sum;
            }
        }
        int ans = 0;
        for( auto& [k, v] : sumMap ) {
            ans = max(ans, v);
        }
        cout << ans << endl;
    }
};
