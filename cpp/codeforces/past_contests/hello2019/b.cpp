#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int n; cin >> n;
    vector<int> input(n);
    for(int i = 0; i < n; ++i) cin >> input[i];
    for(int i = 0; i < ( 1 << n ); ++i) {
        int angle = 0;
        for(int j = 0; j < n; ++j) {
            if( i & (1 << j) ) angle += input[j];
            else angle -= input[j];
        }
        angle = abs(angle);
        if( angle % 360 == 0 ) { cout << "YES" << endl; return 0; }
    }
    cout << "NO" << endl;
}
