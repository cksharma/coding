#include <bits/stdc++.h>
using namespace std;

static const double PI = 3.14159265358979323846;
class CNNAndTheOpticalIllusion {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        double n, r; cin >> n >> r;

        double x = (n - 2) / (2*n) * 180;
        double cosx = cos( x * PI / 180.0 );
        double R = (r * cosx) / ( 1- cosx);
        cout << R << endl;
    }
};
