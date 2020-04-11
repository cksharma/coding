#include <bits/stdc++.h>
using namespace std;

bool isPalin(const string& s, int i, int j) {
    if (i >= j) return true;
    while (i < j) {
        if (s[i] != s[j]) return false;
        ++i;
        --j;
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    string s;
    cin >> s;
    int N = s.size();
    int i1 = 0, i2 = (N - 1) / 2 - 1;
    int j1 = (N + 3) / 2 - 1, j2 = N - 1;
    if (isPalin(s, 0, N - 1) && isPalin(s, i1, i2) && isPalin(s, j1, j2)) {
        cout << "Yes\n";
    } else {
        cout << "No\n";
    }
}
