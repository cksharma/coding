#include <bits/stdc++.h>
using namespace std;

class CFly {
public:

    bool enough(double fuel, double rocket, const vector<int>& a, const vector<int>& b) {
        double totalWeight = fuel + rocket;
        double fueltolift = totalWeight / a[0];
        fuel -= fueltolift;
        totalWeight -= fueltolift;
        for (int i = 1; i < a.size(); ++i) {

            double fueltoland = totalWeight / b[i];
            fuel -= fueltoland;
            totalWeight -= fueltoland;

            double fueltolift = totalWeight / a[i];
            fuel -= fueltolift;
            totalWeight -= fueltolift;
        }

        double fueltoland = totalWeight / b[0];
        fuel -= fueltoland;
        totalWeight -= fueltoland;
        return fuel >= 0 && totalWeight >= 0;
    }

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int n, m; cin >> n >> m;
        vector<int> a(n); for (int i = 0; i < n; ++i) cin >> a[i];
        vector<int> b(n); for (int i = 0; i < n; ++i) cin >> b[i];

        double H = 1e9 + 0.1;
        double low = 0, high = H;
        while (low < high ) {
            if (abs(low - high) < 1e-9) break;
            double middle = (low + high) / 2;
            if (abs(middle - H) < 1e-4) { low = -1; high = -1; break; }

            if (enough( middle, m, a, b)) {
                high = middle;
            } else {
                low = middle;
            }
        }
        cout << (low + high)/2 << endl;
    }
};
