#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    string s; cin >> s;
    for(int i = 0; i < 5; ++i) {
        string str; cin >> str;
        for(int j = 0; j < 2; ++j) if(s[j] == str[j]) {
            cout << "YES"<< endl;
            return 0;
        }
    }
    cout << "NO" << endl;
}
