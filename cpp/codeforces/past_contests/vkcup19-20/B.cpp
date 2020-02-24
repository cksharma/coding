#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    int t, a, b, p;
    string s;
    cin >> t;
    while (t-- > 0) {
        cin >> a >> b >> p;
        map<char, int> mp;
        mp.insert({'A', a});
        mp.insert({'B', b});
        
        cin >> s;
        //s = "X" + s;
        
        int n = s.size();
        
        // Need to walk until the end
        if (mp[s[n - 2]] > p) {
            cout << (n) << '\n';
        } else {
            char ch = s[n - 2]; int i = n - 2;
            p -= mp[ch];
            for (; i >= 0; --i) {
                char tmp = s[i];
                if (tmp == ch) continue;
                if (mp[tmp] > p) { i++; break; }
                p -= mp[tmp];
                ch = tmp;
            }
            cout << max(1, (i + 1)) << '\n';
        }   
    }    
}
