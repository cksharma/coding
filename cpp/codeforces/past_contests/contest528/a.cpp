#include <bits/stdc++.h>
using namespace std;

int main()
{
    string t, str;
    cin >> t;
    int taken = 0;
    int left = (t.size() - 1) / 2;
    int right = left + 1;
    while( taken < t.size() ) {
        if( taken % 2 == 0) {
            str = str + t[left];
            left--;
        } else {
            str = str + t[right];
            right++;
        }
        taken++;
    }
    cout << str << endl;
}