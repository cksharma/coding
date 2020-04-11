#include <bits/stdc++.h>
using namespace std;

int main() {
    long long n;
    long long x, y;
    cin >> n >> x >> y;
    
    long long whiteSteps = min( x, y ) - 1LL + max(x, y ) - min(x, y);
    long long blackSteps = n - max(x, y) + max(x, y) - min(x, y);
    
    string ans = whiteSteps <= blackSteps ? "White" : "Black";
    cout << ans << endl;
    return 0;
}