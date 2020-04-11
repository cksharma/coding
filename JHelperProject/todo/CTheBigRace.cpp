#include <bits/stdc++.h>
using namespace std;

long long GCD (long long a, long long b) {
    if (a < 0) return GCD(-a, b);
    if (b < 0) return GCD(a, -b);
    return b == 0 ? a : GCD(b, a % b);
}

long long LCM(long long a, long long b) {
    if (a < 0)
        return LCM(-a, b);
    if (b < 0)
        return LCM(a, -b);
    return a * (b / GCD(a, b));
}

class CTheBigRace {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        long long t, w, b;
        cin >> t >> w >> b;

        auto pqFormat = [](long long p, long long q) {
            long long gcd = __gcd(p, q);
            while(p % gcd == 0 && gcd != 1) p /= gcd;
            while(q % gcd == 0 && gcd != 1) q /= gcd;
            return to_string(p) + "/" + to_string(q);
        };

        if( w == b ) {
            cout << "1/1" << endl;
            return;
        } else if ( min(w, b) == 1 ) {
            long long nume = t / max(w, b);
            long long deno = t;
            cout << pqFormat( nume, deno ) << endl;
        } else {
            long long lcm = LCM( w, b );
            long long nume = ceil( 1. * (t) / lcm ) + ( t / lcm);
            long long deno = t;
            cout << pqFormat( nume, deno ) << endl;
        }
    }
};
