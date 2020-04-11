#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int t; cin >> t;
    while(t-- > 0) {
        int n; cin >> n;
        int a; cin >> a;
        string res = "YES";
        for (int i = 1; i < n; ++i) {
            int b; cin >> b;
            if (a % 2 != b % 2) res = "NO";
        }
        cout << res << endl;
    }
}
