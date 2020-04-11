#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n; cin >> n;
    vector<long long> arr(n);
    long long sum = 0;
    unordered_map<long long, int> cntMap;
    for(int i = 0; i < n; ++i) {
        cin >> arr[i];
        sum += arr[i];
        cntMap[ arr[i] ]++;
    }

    vector<long long> ans;
    for(int i = 0; i < arr.size(); ++i) {
        long long remSum = sum - arr[i];
        cntMap[ arr[i] ]--;
        if( remSum % 2 == 0 && cntMap[ remSum / 2 ] > 0 ) {
            ans.push_back( i + 1 );
        }
        cntMap[ arr[i] ]++;
    }

    cout << ans.size() << endl;
    for(int i = 0; i < ans.size(); ++i) {
        cout << ans[i] << " ";
    }

    return 0;
}
