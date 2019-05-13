#include <bits/stdc++.h>
using namespace std;

#define LL long long

void solve( LL sum, LL myMinSum, LL hisMinSum, LL hisMaxSum,
            vector<LL>& arr, LL i )
{
    LL myMaxSum = sum - myMinSum;
    if( myMinSum > myMaxSum ) return;

    if( ( myMinSum >= hisMinSum && myMaxSum <= hisMaxSum ) ||
            (myMinSum == myMaxSum) || (myMinSum + 1 == myMaxSum ) ) {
        arr[i] = myMinSum;
        arr[( arr.size() - 1) - i + 1] = myMaxSum;
        return;
    }

    if( myMinSum < hisMinSum ) {
        solve( sum, hisMinSum, hisMinSum, hisMaxSum, arr, i);
    } else if ( myMaxSum > hisMaxSum ) {
        solve( sum, sum - hisMaxSum, hisMinSum, hisMaxSum, arr, i);
    } else {
        LL average = ( myMinSum + hisMinSum ) / 2;
        solve( sum, average, hisMinSum, hisMaxSum, arr, i );
    }
}

void solveConstant(LL mySum, LL hisMin, LL hisMax, vector<LL>&arr, int i)
{
    LL hisSum = hisMin + hisMax;
    if( hisSum >= mySum ) {
        arr[i] = hisMin;
        arr[arr.size() - 1 - i + 1] = mySum - hisMin;
    } else {
        arr[arr.size() - 1 - i + 1] = hisMax;
        arr[i] = mySum - hisMax;
    }
}

int main()
{
    LL n; cin >> n;
    vector<LL> arr(n + 1);

    vector<LL> input( n /  2 + 1);
    for(LL i = 1; i <= n / 2; ++i) cin >> input[i];

    arr[1] = 0;
    arr[n] = input[1];

    for (LL i = 2; i <= n / 2; ++i) {
        LL j = i - 1;
        //solve(input[i], 0, arr[j], arr[n - j + 1], arr, i);
        solveConstant(input[i], arr[j], arr[n - j + 1], arr, i);
    }

    for(LL i = 1; i <= n; ++i) cout << arr[i] << " ";
    cout << "\n";
}