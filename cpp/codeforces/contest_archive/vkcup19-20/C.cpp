#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t-- > 0) {
        int n; cin >> n;
        vector<int> v(n);
        for (int i = 0; i < n; ++i) cin >> v[i];
        
        set<int> st;
        for (int i = 1; i <= 2 * n; ++i) st.insert(i);
        for (int item : v) if (st.find(item) != st.end()) { st.erase(item);}
        
        vector<int> result(2 * n); bool flag = true;
        for (int i = 0; i < n; ++i) {
            result[2 * i] = v[i];
            
            auto it = lower_bound(st.begin(), st.end(), v[i] + 1);
            if (it == st.end()) {
                flag = false;
                break;
            }
            int num = *it;
            result[2 * i + 1] = num;
            st.erase(num);
        }
        if (flag == false) {
            cout << -1 << endl;
        } else {
            for (int item : result) cout << item << " ";
            cout << endl;
        }
    }    
}
