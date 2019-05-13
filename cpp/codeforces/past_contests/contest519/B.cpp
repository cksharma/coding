#include <bits/stdc++.h>
using namespace std;

bool checkPossibility(int k, const vector<int>& v) {
    map<int, int> mp;
    mp[0] = v[0];
    for(int i = 1; i < v.size(); i++) {
        int xInd = i % k;
        int xExp = v[i] - v[i - 1];
        auto it = mp.find(xInd);
        if( it == mp.end() ) {
            mp.insert( {xInd, xExp} );
        } else {
            if( it->second != xExp ) return false;
        }
    }
    return true;
}

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++) cin >> v[i];
    
    vector<int> ans;
    for(int k = 1; k <= n; k++) {
        if ( checkPossibility(k, v) ) ans.push_back( k );
    }
    
    // OUTPUT PRINT
    cout << ans.size() << endl;
    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
    cout << endl;
    return 0;
}