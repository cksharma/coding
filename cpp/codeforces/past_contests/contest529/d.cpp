#include <bits/stdc++.h>
using namespace std;

map< int, vector<int> > mp;
vector< pair<int, int> > v;
int n;

bool solve(int cnt)
{
    vector<int> ans(n + 1);

    pair<int, int> neighbours = v[1];
    ans[1] = 1;
    ans[2] = neighbours.first;
    ans[3] = neighbours.second;
    if( cnt == 1) swap( ans[2], ans[3] );

    for(int i = 2; i <= n - 2; ++i) {
        int seed = ans[i];
        neighbours = v[seed];
        if( neighbours.first == ans[i + 1 ] ) {
            ans[i + 2] = neighbours.second;
        } else if ( neighbours.second == ans[i + 1] ) {
            ans[i + 2] = neighbours.first;
        } else {
            return false;
        }
    }
    for(int i = 1; i <= n; ++i) cout << ans[i] << " ";
    cout << endl;
    return true;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    mp.clear();
    v.clear();

    cin >> n;
    v.reserve(n + 1);
    for(int i = 1; i <= n; ++i)
    {
        int a, b;
        cin >> a >> b;
        mp[a].push_back(b);
        mp[b].push_back(a);
        v[i] = {a, b};
    }
    solve( 0 ) || solve( 1 );
    return 0;
}

