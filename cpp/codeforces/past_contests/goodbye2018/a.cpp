#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int me, him, himhim;
    cin >> me >> him >> himhim;

    int a = min( me, min( him - 1, himhim - 2 ));
    int b = min( him, min( me + 1, himhim - 1));
    int c = min( himhim, min( me + 2, him + 1 ));
    cout << a + b + c << endl;
}
