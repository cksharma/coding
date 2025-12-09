#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void solve() {
    int n;
    cin >> n;
    vector<long long> a(n);
    long long sum = 0;
    long long max_val = 0;
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        sum += a[i];
        max_val = max(max_val, a[i]);
    }
    
    // Theory: sum + (n-2) * max
    long long ans = sum + (n - 2) * max_val;
    cout << ans << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
