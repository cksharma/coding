#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    
    vector<vector<int>> v(3, vector<int>(3));
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            cin >> v[i][j];
        }
    }
    int N; cin >> N;
    for (int i = 0; i < N; ++i) {
        int num; cin >> num;
        for (int i = 0; i < 3; ++i) for (int j = 0; j < 3; ++j) if (v[i][j] == num) v[i][j] = -1;
    }
    
    bool ans = (v[0][0] == -1 && v[0][1] == -1 && v[0][2] == -1) ||
               (v[1][0] == -1 && v[1][1] == -1 && v[1][2] == -1) ||
               (v[2][0] == -1 && v[2][1] == -1 && v[2][2] == -1) ||
               (v[0][0] == -1 && v[1][0] == -1 && v[2][0] == -1) ||
               (v[0][1] == -1 && v[1][1] == -1 && v[2][1] == -1) ||
               (v[0][2] == -1 && v[1][2] == -1 && v[2][2] == -1) ||
               (v[0][0] == -1 && v[1][1] == -1 && v[2][2] == -1) ||
               (v[0][2] == -1 && v[1][2] == -1 && v[2][2] == -1) ||
               (v[0][2] == -1 && v[1][1] == -1 && v[2][0] == -1);
    if (ans) cout << "Yes" << endl;
    else cout << "No" << endl;
}
