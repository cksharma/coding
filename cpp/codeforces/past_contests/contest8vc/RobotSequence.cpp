#include <bits/stdc++.h>
using namespace std;

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n; string s;
    cin >> n >> s;
    int ways = 0;
    for (int start = 0; start < n; start++) {
        int up = 0, dw = 0, lt = 0, rt = 0;
        for (int i = start; i < n; i++) {
            if (s.at(i) == 'U') up++;
            else if (s.at(i) == 'D') dw++;
            else if (s.at(i) == 'L') lt++;
            else rt++;
            if (up == dw && lt == rt) ways++;
        }
    }
    cout << ways << endl;
}