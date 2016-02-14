#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr.begin(), arr.end());
    if (n == 1) {
        cout << -1 << endl;
    } else if (n == 2) {
        int diff = arr[1] - arr[0];
        int isEven = diff % 2 == 0;
        set<int> st;

        if (isEven) {
            st.insert(arr[0] - diff);
            st.insert((arr[0] + arr[1]) / 2);
            st.insert(arr[n - 1] + diff);
        }
        else {
            st.insert(arr[0] - diff);
            st.insert(arr[1] + diff);
        }
        cout << st.size() << endl;
        for (auto& it : st) {
            cout << it << " ";
        }
        cout << endl;
    } else {
        bool sameDiff = true;
        int diff = arr[1] - arr[0];

        vector<int> vd;
        for (int i = 1; i < arr.size(); i++) {
            if (diff != arr[i] - arr[i - 1]) {
                sameDiff = false;
            }
            vd.push_back(arr[i] - arr[i - 1]);
        }

        if (sameDiff) {
            if (arr[0] == arr[1]) {
                cout << 1 << endl;
                cout << arr[0] << endl;
            } else {
                cout << 2 << endl;
                cout << arr[0] - diff << " " << arr[n - 1] + diff << endl;
            }
        } else {
            int min = *min_element(vd.begin(), vd.end());
            int max = *max_element(vd.begin(), vd.end());
            int maxCount = 0;
            for (int &item : vd) {
                if (item == max) maxCount++;
            }
            if (maxCount == 1 && max == 2 * min) {
                cout << 1 << endl;
                for (int i = 1; i < arr.size(); i++) {
                    if (arr[i] - arr[i - 1] == max) {
                        cout << arr[i - 1] + min << endl;
                        break;
                    }
                }
            } else {
                cout << 0 << endl;
            }
        }
    }
}
