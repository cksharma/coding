#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); 
    cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); 
    cout.precision(10);

    vector<int> v(3, -1);
    bool bad = false;
    int N, M; cin >> N >> M;
    for (int i = 0; i < M; ++i) {
        int s, c;
        cin >> s >> c;
        int idx = s - 1;
        if (v[idx] == -1 || v[idx] == c) { v[idx] = c; continue;}
        bad = true;
    }
    if (N == 3)
    {
        if (bad || v[0] == 0) cout << -1 << endl;
        else {
            if (v[0] == -1) v[0] = 1;
            if (v[1] == -1) v[1] = 0;
            if (v[2] == -1) v[2] = 0;
            cout << v[0] * 100 + v[1] * 10 + v[2] << endl;
        }
    } else if (N == 2) {
        if (bad || v[0] == 0) cout << -1 << endl;
        else {
            if (v[0] == -1) v[0] = 1;
            if (v[1] == -1) v[1] = 0;
            cout << v[0] * 10 + v[1] << endl;
        }
    } else {
        if (bad) cout << -1 << endl;
        else {
            if (v[0] == -1) v[0] = 0;
            cout << v[0] << endl;
        }
    }
}
