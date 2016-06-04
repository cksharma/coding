#include <bits/stdc++.h>
using namespace std;

int getIndexFromVector(vector<int>& v, int num) {
    for (int i = 0; i < v.size(); i++) {
        if (v[i] <= num) return i;
    }
    return -1;
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    vector<int> v;

    for (int i = 0; i < n; i++) {
        int index = getIndexFromVector(v, arr[i]);
        if (index == -1) {
            v.push_back(1);
        } else {
            v[index] += 1;
        }
    }
    cout << v.size() << endl;
}
