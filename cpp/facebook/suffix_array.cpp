#include <bits/stdc++.h>
using namespace std;

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (int item : v) os << item << ",";
    return os;
}

void suffix_construction() {
    string str = "banana";
    vector<int> arr(str.size());
    for (int i = 0; i < str.size(); ++i) arr[i] = i;

    auto cmp = [&](int i, int j) {
        while (i < str.size() && j < str.size()) {
            if (str[i] != str[j]) return str[i] < str[j];
            i++;
            j++;
        }
        if (i == str.size() && j == str.size()) return false;
        if (i == str.size()) return true;
        return false;
    };
    sort(arr.begin(), arr.end(), cmp);
    cout << "Suffix" << arr << endl;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    suffix_construction();
}
