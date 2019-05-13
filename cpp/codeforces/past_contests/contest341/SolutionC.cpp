#include <bits/stdc++.h>
using namespace std;

int countPrimes(int left, int right, int p) {
    int ans = 0;
    if (left % p == 0) ans++;
    ans += (right / p - left / p);
    return ans;
}

int total(int left, int right) {
    return right - left + 1;
}

int main() {
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n, p, l, r;
    cin >> n >> p;
    vector<pair<int, int>> v;
    for (int i = 0; i < n; i++) {
        cin >> l >> r;
        v.push_back(make_pair(l, r));
    }
    std::setprecision(100);
    long double nume = 0., deno = 0., ans = 0.;
    for (int i = 0; i < v.size(); i++) {
        int next = (i + 1) % n;

        int lc = v[i].first, rc = v[i].second;
        int ln = v[next].first, rn = v[next].second;

        int totalC = total(lc, rc);
        int totalN = total(ln, rn);

        int primeC = countPrimes(lc, rc, p);
        int nprimec = totalC - primeC;

        int primeN = countPrimes(ln, rn, p);
        int nprimen = totalN - primeN;
        deno = 0., nume = 0.;

        deno = (1. * totalN * totalC);
        nume = 2. * primeN * totalC + 2. * primeC * nprimen;

        /*cout << primeC << " " << nprimec << " " << totalC << endl;
        cout << primeN << " " << nprimen << " " << totalN << endl;
        cout << nume << " " << deno << endl;
        cout << endl;*/
        ans += 1000. * nume / deno;
    }
    std::setprecision(100);
    cout << ans << endl;
}
