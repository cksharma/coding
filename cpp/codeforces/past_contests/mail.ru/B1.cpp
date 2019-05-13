#include <bits/stdc++.h>
using namespace std;

int main() {
    long long n, m, l;
    cin >> n >> m >> l;
    int cnt = 0;
    vector<long long> arr(n + 2, 0);

    for(int i = 1; i <= n; ++i) {
        cin >> arr[i];
        if( arr[i - 1] > l && arr[i] <= l ) ++cnt;
        else if( i == n && arr[i] > l ) ++cnt;
    }

    for(int i = 1; i <= m; ++i) 
    {
        int flag; cin >> flag;
        if( flag == 0 ) 
        {
            cout << cnt << endl;
        }
        else 
        {
            int p, d; cin >> p >> d;
            if( arr[p - 1] > l && arr[p] <= l && arr[p + 1] > l && arr[p] + d > l) --cnt;
            else if ( arr[p - 1] <= l && arr[p + 1] <= l && arr[p] <= l && arr[p] + d > l ) ++cnt;
            arr[p] += d;                        
        }
    }
    return 0;
}