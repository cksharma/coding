#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t-- > 0) {
        int n, x, y;
        cin >> n >> x >> y;
        
        int f_t = x - 1;
        int f_b = n - x;
        
        int s_t = y - 1;
        int s_b = n - y;
        
        int worst = min(f_t, s_b) + min(s_t, f_b) + 1;
        
        int best = min(min(f_t, s_b), min(s_t, f_b));
        
        cout << max(1, best) << " " << worst << endl;
    }
}