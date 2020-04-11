#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while(t--) {
        int n, k;
        string str;
        cin >> n >> k;
        int factor = n / k;
        for(int i = 0; i < k; ++i) {
            str += string(  factor, char(97 + i) );
        }
        int rem = n % k;
        str += string(  rem, char(97 + k - 1) );
        cout << str << endl;
    }
    return 0;
}