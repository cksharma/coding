#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int n; cin >> n;
    string str; cin >> str;
    string ans; int jmp = 1;
    for(int i = 0; i < n; ) {
        ans += str[i];
        i += jmp;
        jmp++;
    }
    cout << ans << endl;
}
