#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    unordered_map<int, int> cntMap;
    for(int i = 0; i < n; ++i) {
        cin >> arr[i];
        cntMap[ arr[i] ]++;
    }
    int factor = 0;
    for(auto& p : cntMap) {
        int cnt = p.second;
        factor = max( factor, int(ceil( 1.0 * cnt / k) * k ) );
    }
    cout << cntMap.size() * factor - n << endl;
    return 0;
}