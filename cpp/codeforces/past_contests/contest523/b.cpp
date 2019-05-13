#include <bits/stdc++.h>
using namespace std;

typedef long long int64;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int64 n, m;
    cin >> n >> m;
    vector<int64> arr( n );

    int64 sum = 0LL;
    for(int i = 0; i < n; ++i) {
        cin >> arr[i];
        sum += arr[i];
    }

    if( n == 1) {
        cout << 0 << endl;
        return 0;
    }
    sort(arr.rbegin(), arr.rend());
    int64 seed = arr[0], take = 0;

    for(int i = 0; i < n; ++i) {
        int64 diff = seed - arr[i];
        seed--; take++;
        if( diff > 0) seed -= diff, take += diff;
        seed = min( seed, arr[i]);
    }
    if( seed > 0) take += seed;

    cout << sum - take << endl;
    return 0;
}