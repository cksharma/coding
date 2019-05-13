#include <bits/stdc++.h>
using namespace std;

struct State {
    int num;
    int cnt;
    State( int n, int c) : num(n), cnt(c) {}

    bool operator<(const State& s) const {
        if( s.num != num ) {
            if( s.cnt != cnt ) return s.cnt < cnt;
            return num < s.num;
        }
        return false;
    }
};

int main()
{
    int n; cin >> n; int k; cin >> k;
    set<State> cntMap;
    vector<State> states;
    unordered_map<int, int> mp;
    for(int i = 0; i < n; i++) {
        int kk; cin >> kk;
        mp[kk]++;
    }
    for(auto& p : mp) {
        State s(p.first, p.second);
        cntMap.insert( s );
    }

    /*for(auto& p : cntMap) {
        cout << p.num << ", " << p.cnt << " ";
    }*/

    int cnt = 0;
    while( cnt < k && cntMap.size() > 0 ) {
        State first = *cntMap.begin();
        cout << first.num << " ";
        cntMap.erase( cntMap.begin() );
        first.cnt -= min(k, n / k);
        if( first.cnt > 0 ) {
            cntMap.insert( first );
        }
        ++cnt;
    }

    return 0;
}
