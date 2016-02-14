#include <bits/stdc++.h>
using namespace std;
int main() {
    string first, secon;
    cin >> first >> secon;
    vector<int> v;
    int index = 0;
    while (true) {
        index = first.find_first_of(secon, index);
        if (index != string::npos) index++;
        else break;
        v.push_back(index);
    }
    int ans = 0;
    for (int i = 0; i < v.size(); i++) {
        int now = v[i];
        bool flag = false;
        while (i + 1 < v.size() && now + secon.length() <= v[i + 1]) {
            i++;
            flag = true;
        }
        if (flag) i--;
        ans++;
    }
    cout << ans << endl;
}