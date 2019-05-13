#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    vector<int> arr(n + 2, 0);
    for(int i = 1; i <= n; ++i) cin >> arr[i];

    vector<int> ans( n + 2, 0);
    bool good = true;
    for (int s = 0; s < 4; s++) {
        good = true;
        if(s == 0) arr[0] = arr[n + 1] = 0;
        if(s == 1) arr[0] = arr[n + 1] = INT_MAX;
        if(s == 2) arr[0] = 0, arr[n + 1] = INT_MAX;
        if(s == 3) arr[0] = INT_MAX, arr[n + 1] = 0;

        for(int i = 1; i <= n; ++i) {
            int prv = arr[i - 1];
            int mee = arr[i];
            int nex = arr[i + 1];

            if( mee > prv && mee < nex ) {
                ans[i] = ans[i - 1] + 1;
            } else if ( mee > prv && mee > nex ) {
                ans[i] = max( 5, ans[i - 1] + 1);
            } else if ( mee < prv && mee < nex ) {
                ans[i] = min(1, ans[i - 1] - 1);
            } else if ( mee < prv && mee > nex ) {
                ans[i] = ans[i - 1] - 1;
            } else if ( mee == prv && mee == nex ) {
                ans[i] = ( ans[i - 1] == 1 ) ? 2 : ans[i - 1] - 1;
            } else if ( mee == prv ) {
                if( mee < nex ) {
                    ans[i] = ( ans[i - 1] == 1 ) ? 2 : 1;
                } else {
                    ans[i] = ( ans[i - 1] == 5 ) ? 4 : 5;
                }
            } else if ( mee == nex ) {
                if( mee < prv ) {
                    ans[i] = min(1, ans[i - 1] - 1);
                } else {
                    ans[i] = ans[i - 1] + 1;
                }
            }
            if( ans[i] < 1 || ans[i] > 5) { good = false; break; }
        }
        if( good == false) continue;
        else break;
    }

    if( good ) {
        for(int i = 1; i <= n; ++i) cout << ans[i] << " ";
    } else {
        cout << -1;
    }
    cout << endl;
    return 0;
}