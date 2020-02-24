#include <bits/stdc++.h>
#define long long long
using namespace std;

int threeSplit(std::vector<int> a) {
    int ans = 0;
    long sum = accumulate(a.begin(), a.end(), 0LL);
    int n = a.size();
    vector<int> cumu(n, 0);
    vector<int> rev_cumu(n, 0);

    cumu[0] = a[0];
    for (int i = 1; i < n; ++i) {
        cumu[i] = cumu[i - 1] + a[i];
    }

    rev_cumu[n - 1] = a[n - 1];
    for (int i = n - 2; i >= 0; --i) {
        rev_cumu[i] = rev_cumu[i + 1] + a[i];
    }

    vector<pair<int, int>> vp(n, make_pair(0, 0));
    for (int i = 0; i < n; ++i) {
        if (3 * cumu[i] == sum) vp[i].first = 1;
    }
    for (int i = n - 1, three = 0; i >= 0; --i) {
        if (3 * rev_cumu[i] == sum) three++;
        vp[i].second = three;
    }

    for (int i = 0; i + 2 < vp.size(); ++i) {
        ans += vp[i].first * vp[i + 2].second;
    }
    return ans;
}


int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    cout << threeSplit({0, -1, 0, -1, 0, -1}) << endl;
    cout << threeSplit({-1, 0, -1, 0, -1, 0}) << endl;

}
