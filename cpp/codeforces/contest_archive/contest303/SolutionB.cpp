#include <bits/stdc++.h>

using namespace std;

int main() {
    string s, t;
    cin >> s >> t;
    string p;
    int diff = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.at(i) != t.at(i)) diff++;
    }
    if (diff % 2 == 1) {
        cout << "impossible" << endl;
    } else {
        bool first = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.at(i) == t.at(i)) {
                p += s.at(i);
            } else {
                if (first) p += s.at(i);
                else p += t.at(i);
                first = !first;
            }
        }
    }
    cout << p << endl;
}

