#include <bits/stdc++.h>
#include <stdio.h>
using namespace std;

int main() {
    int n; cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    int sum = 0; int ans = 0;
    for (int i = 0; i < n; i++) {
        if (sum <= arr[i]) ans++, sum += arr[i];
    }
    cout << ans << endl;
}