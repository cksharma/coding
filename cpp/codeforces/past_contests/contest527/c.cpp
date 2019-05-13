#include <bits/stdc++.h>
using namespace std;

bool ok(const string& ss, map<int, vector<int>>& mp,
        const vector<string>& input, string& result )
{
    for(int len = 1; len < ss.length(); ++len) {
        string f = input[mp[len][0]];
        string s = input[mp[len][1]];
        if( ss.substr(0, len) == f && ss.substr(ss.length() - len ) == s ) {
            result[ mp[len][0] ] = 'P';
            result[ mp[len][1] ] = 'S';
        } else if ( ss.substr(0, len) == s && ss.substr(ss.length() - len ) == f ) {
            result[ mp[len][0] ] = 'S';
            result[ mp[len][1] ] = 'P';
        } else {
            return false;
        }
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    int n; cin >> n;
    vector<string> input;
    map<int, vector<int> > mp;
    for(int i = 0; i < 2 * n - 2; ++i) {
        string s; cin >> s;
        mp[s.length()].push_back(i);
        input.push_back(s);
    }
    vector<string> possible;
    for(int i = 0; i < mp[1].size(); ++i) {
        for(int j = 0; j < mp[n - 1].size(); ++j) {
            int idx1 = mp[1][i];
            int idx2 = mp[n - 1][j];
            if( idx1 == idx2 ) continue;
            possible.push_back( input[idx1] + input[idx2] );
            possible.push_back( input[idx2] + input[idx1] );
        }
    }
    for(string ss : possible) {
        string result(2 * n - 2, 'X');
        if( ok(ss, mp, input, result ) ) {
            cout << result << endl;
            break;
        }
    }
    return 0;
}
