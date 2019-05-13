#include <bits/stdc++.h>
using namespace std;
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

const int N = 1e6 + 5;
int cnt[N];

const int MOD = 1e9 + 7;

int main()
{
    IOS;

    fill(cnt, cnt + N, 0);
    cnt[0] = 1;

    int n; cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; i++) cin >> arr[i];

    for(int i = 0; i < n; i++) {
        int num = arr[i];
        set<int, std::greater<int>> factors;
        for(int j = 1; j * j <= num; j++) {
            if( num % j == 0) {
                factors.insert( j );
                factors.insert( num / j );
            }
        }
        for(auto item : factors) {
            cnt[item] += cnt[item - 1];
            cnt[item] %= MOD;
        }
    }
    long long ans = 0;
    for(int i = 1; i <= n; i++) {
        ans += cnt[i]; 
        ans %= MOD;
    }

    cout << ans << endl;

    return 0;
}