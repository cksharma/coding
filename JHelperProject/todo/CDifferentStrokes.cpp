#include <bits/stdc++.h>
using namespace std;

struct Happiness {
    int a;
    int b;
    int index;
};

class CDifferentStrokes {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int n; cin >> n;
        vector<Happiness> A;
        vector<Happiness> B;
        for (int i = 0; i < n; ++i) {
            int a, b; cin >> a >> b;
            A.push_back({a, b, i});
            B.push_back({a, b, i});
        }

        sort(A.begin(), A.end(), [](const Happiness& lhs, const Happiness& rhs) {
            int diff1 = lhs.a - rhs.b;
            int diff2 = rhs.a - lhs.b;
            if ( diff1 > diff2 ) return true;
            return false;
        });

        sort(B.begin(), B.end(), [](const Happiness& lhs, const Happiness& rhs) {
            int diff1 = lhs.b - rhs.a;
            int diff2 = rhs.b - lhs.a;
            if ( diff1 > diff2 ) return true;
            return false;
        });
        
        set<int> visited; int aIndex = 0, bIndex = 0;
        long long ans = 0LL;
        while (aIndex < n && bIndex < n) {
            while (aIndex < n) {
                Happiness& h = A[aIndex];
                if (visited.find(h.index) != visited.end()) { aIndex++; continue; }
                ans += A[aIndex].a;
                aIndex++;
                visited.insert(h.index);
                break;
            }
            while (bIndex < n) {
                Happiness& h = B[bIndex];
                if (visited.find(h.index) != visited.end()) { bIndex++; continue; }
                ans -= B[bIndex].b;
                bIndex++;
                visited.insert(h.index);
                break;
            }
        }
        cout << ans << endl;
    }
};
