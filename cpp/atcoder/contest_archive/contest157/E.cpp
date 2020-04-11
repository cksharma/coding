#include <bits/stdc++.h>
using namespace std;

int main()
{   
    int N, Q; string S;
    cin >> N >> S >> Q;
    
    vector<set<int>> vsi(26);
    for (int i = 0; i < S.size(); ++i) {
        vsi[S[i] - 'a'].insert(i);
    }
    for (int i = 0; i < Q; ++i) {
        int t; 
        cin >> t;
        if (t == 1) {
            int p; char c;
            cin >> p >> c; p--;
            char sc = S[p];
            vsi[sc - 'a'].erase(p);
            S[p] = c;
            vsi[c - 'a'].insert(p);
        } else {
            int l, r;
            cin >> l >> r; l--; r--;
            int ans = 0;
            for (char c = 0; c < 26; ++c) {
                auto it = vsi[c].lower_bound(l);
                if (it != vsi[c].end() && *it <= r) ++ans;
            }
            cout << ans << endl;
        }
    }
}
