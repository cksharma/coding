#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int t; cin >> t;
    while(t-- > 0) {
        string s;
        cin >> s;
        int ans = INT_MIN;
        int cons = 1;
        for (char ch : s) {
            if (ch == 'L') ++cons;
            else cons = 1;
            ans = max(ans, cons);
        }
        cout << ans << endl;
    }
}
