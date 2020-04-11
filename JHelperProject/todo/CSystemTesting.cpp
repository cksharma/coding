#include <bits/stdc++.h>
using namespace std;

struct Process {
    int id;
    int remainTest;
};

bool operator<(const Process& lhs, const Process& rhs) {
    if (lhs.remainTest != rhs.remainTest)
        return lhs.remainTest < rhs.remainTest;
    return lhs.id < rhs.id;
}

class CSystemTesting {
public:

    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, k; cin >> n >> k;
        vector<int> a(n);
        for (int i = 0; i < n; ++i) cin >> a[i];

        vector<int> vec = a;

        int ans = 0;
        int m = 0;
        int testSum = 0;
        while (true) {
            set<Process> process;
            for (int i = 0; i < n && process.size() < k; ++i) {
                if (a[i] == 0 ) continue; // Already processed
                process.insert( Process{i, a[i]} );
            }
            if (process.size() == 0) break;

            Process min = *process.begin();



            testSum += min.remainTest;
            //cout << d << ", ";

            for (auto it = process.begin(); it != process.end(); ++it) {
                int id = it->id;
                if (a[id] - min.remainTest == 0) {
                    ++m;
                }
            }
            int d = round(100. * m / n);
            for (auto it = process.begin(); it != process.end(); ++it) {
                int id = it->id;
                if (a[id] - min.remainTest > 0) {

                }
                a[id] -= min.remainTest;
            }
        }
        //cout << endl;
        cout << ans << endl;
    }
};
