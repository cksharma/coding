#include <bits/stdc++.h>
using namespace std;

int x,y;

bool ok(int len)
{
    int sum = abs(x) + abs(y);
    return sum <= len && sum % 2 == len % 2;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    string input;
    cin >> input;
    cin >> x >> y;

    if(ok(n)) {
        cout << -1 << endl;
        return 0;
    }



    return 0;
}