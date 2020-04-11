#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int n; cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; ++i) cin >> arr[i];
    sort( arr.begin(), arr.end());
    cout << min( arr[n - 1] - arr[1], arr[n - 2] - arr[0] ) << endl;
}
