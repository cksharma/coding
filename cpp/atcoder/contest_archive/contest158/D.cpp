#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    string s; int Q;
    cin >> s >> Q;
    
    list<char> lst;
    for (int i = 0; i < s.size(); ++i) {
        lst.push_back(s[i]);
    }
    
    bool front = true;
    for (int i = 0; i < Q; ++i) {
        int t; cin >> t;
        if (t == 2) {
            int f; char c;
            cin >> f >> c;
            if (f == 1) {
                if (front) lst.push_front(c);
                else lst.push_back(c);
            } else {
                if (front) lst.push_back(c);
                else lst.push_front(c);
            }
        }  else {
            front = not front;
        }     
    } 
    string ans;
    if (not front) lst.reverse();
    for (auto it = lst.begin(); it != lst.end(); ++it) {
        ans += *it;
    }
    cout << ans << endl;
}
