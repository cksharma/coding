#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    string s; cin >> s; int k; cin >> k;
    int sf = 0, cc = 0, letters = 0;
    for(int i = 0; i < s.size(); ++i) {
        if( s[i] == '*' ) sf++;
        else if( s[i] == '?' ) cc++;
        else letters++;
    }

    auto impossible = [&]() {
        if( letters - sf - cc > k ) return true;
        if( sf == 0 && letters < k ) return true;
        return false;
    };

    if( impossible() ) {
        cout << "Impossible" << endl;
        return 0;
    }

    string ans;
    if( letters <= k ) {
        int need = k - letters;
        for(int i = 0; i < s.size(); ++i) {
            if( s[i] == '*' )  {
                while( need-- > 0 )
                    ans += s[i - 1];
            } else if ( s[i] == '?' ) {
                ;
            } else {
                ans += s[i];
            }
        }
    } else { // when letters > k. Need to remove some
        int remove = letters - k;
        for(int i = s.size() - 1; i >= 0; --i) {
            if(s[i] == '*' || s[i] == '?') {
                if( remove-- > 0) {
                    --i;
                    continue;
                }
            } else {
                ans = s[i] + ans;
            }
        }
    }
    cout << ans << endl;
}
