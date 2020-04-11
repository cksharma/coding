#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n; cin >> n;
    vector<int> arr(n, 0);
    for(int i = 0; i < n; ++i) cin >> arr[i];
    sort(arr.begin(), arr.end());

    int result = 0;
    for(int i = 0; i < arr.size(); i += 2) {
        result += abs(arr[i] - arr[i + 1]);
    }
    cout << result << endl;
    return 0;
}