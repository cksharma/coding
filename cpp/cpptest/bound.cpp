#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    vector<int> v = {1, 100, 101, 300, 400 };
    auto it = lower_bound( v.begin(), v.end(), 99 );
    auto it2 = upper_bound( v.begin(), v.end(), 99 );
    cout << "Size = " << it2 - it << endl;
}
