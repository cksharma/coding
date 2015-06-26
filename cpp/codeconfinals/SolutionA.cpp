#include <bits/stdc++.h>

using namespace std;

bool isPalin(string s) {
    for (int i = 0; i < s.length() / 2; i++) {
        if (s.at(i) != s.at(s.length() - 1 - i)) return false;
    }
    return true;
}

int main() {
    int n; scanf("%d", &n);
    string S[n];
    for (int i = 0; i < n; i++) cin >> S[i];
    unordered_map<string, int> mp;
    for (int i = 0; i < n; i++) {
        if (isPalin(S[i])) continue;
        mp[S[i]]++;
    }
    int ans = 0;
    for (auto it = mp.begin(); it != mp.end(); it++) {
        string s1 = it->first;
        string s2 = s1; reverse(s2.begin(), s2.end());
        if (mp[s1] != mp[s2]) {
            printf("-1\n");
            return 0;
        }
        ans += mp[s1];
    }
    printf("%d\n", ans / 2);
}