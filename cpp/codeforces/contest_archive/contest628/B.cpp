#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int t; cin >> t;
    while (t-- > 0) {
        int n; cin >> n;
        unordered_set<int> st;
        for (int i = 0; i < n; ++i) {
            int a; cin >> a;
            st.insert(a);
        }
        cout << st.size() << endl;
    } 
}
