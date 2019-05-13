#include <bits/stdc++.h>
using namespace std;

void printMap(map<int, int>& mp) {
    for( auto& [k, v] : mp ) {
        cout << "[" << k << "=" << v << "], ";
    }
    cout << endl;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int n; cin >> n;
    vector<string> input(n);
    for(int i = 0; i < n; ++i) cin >> input[i];

    map<int, int> beforeMap;
    map<int, int> afterMap;

    for(string& s : input) {
        int cnt = 0;
        int negative = INT_MAX;
        for(char ch : s) {
            if( ch == '(' ) cnt++;
            else cnt--;
            if( cnt < 0 && cnt < negative ) {
                negative = cnt;
            }
        }
        if( negative != INT_MAX ) {
            if( cnt == negative )
                afterMap[abs(cnt)]++;
        } else {
            beforeMap[cnt]++;
        }
    }

    //printMap( beforeMap );
    //printMap( afterMap );

    int ans = beforeMap[0] / 2;
    for(auto& [key, val] : beforeMap ) {
        ans += min( beforeMap[key], afterMap[key] );
    }
    cout << ans << endl;
}
