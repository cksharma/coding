#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    int arr[n][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cin >> arr[i][j];
    unordered_set<int> st;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i][j] == -1 || arr[i][j] == 0) continue;
            if (arr[i][j] == 1) st.insert(i + 1);
            if (arr[i][j] == 2) st.insert(j + 1);
            if (arr[i][j] == 3) st.insert(i + 1), st.insert(j + 1);
        }
    }
    cout << n - st.size() << endl;
    for (int i = 1; i <= n; i++) {
        if (st.find(i) != st.end()) continue;
        cout << i << " ";
    }
}