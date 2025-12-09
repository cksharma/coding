#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void solve() {
    int n;
    cin >> n;
    vector<long long> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    
    // Key insight: The maximum element will be the final survivor
    // Every other element must be "consumed" by being merged
    // When an element is merged, we pay max(x, y)
    
    // The total cost is the sum of all elements except the minimum one
    // Because we can arrange merges so that each element (except min) 
    // acts as the "max" in exactly one merge operation
    
    long long total = 0;
    long long min_val = *min_element(a.begin(), a.end());
    
    for (long long x : a) {
        total += x;
    }
    
    cout << total - min_val << endl;
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
