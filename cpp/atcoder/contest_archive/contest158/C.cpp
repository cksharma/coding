#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    int A, B; cin >> A >> B;
    
    int ans = -1;
    
    for (int i = 1; i <= 2000; ++i) {
        int p8 = (i * 0.08);
        int p10 = (i * 0.10);
        if (p8 == A && p10 == B) {
            ans = i; break;
        }
    }
    cout << ans << endl;
}