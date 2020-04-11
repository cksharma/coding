#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    string s;
    cin >> s;
    if (s.find('A') != string::npos && s.find('B') != string::npos) {
        cout << "Yes" << endl;
    } else {
        cout << "No" << endl;
    }
}