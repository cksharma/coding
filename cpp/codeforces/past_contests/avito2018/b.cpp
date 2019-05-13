#include <bits/stdc++.h>
using namespace std;

string IMPOSSIBLE = "Impossible";
string POSSIBLE = "Possible";

void print1(const vector<int>& arr) {
    for(int i = 0; i < arr.size(); ++i)
        cout <<( arr[i] == arr[0]  ? 1 : 2 ) << " ";
    cout << endl;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int n; cin >> n;
    vector< vector<int> > v( n + 1 );
    vector<int> result(n);
    for(int i = 0; i < n; ++i) {
        int a; cin >> a;
        int mine = n - a;
        v[mine].push_back(i);
    }
    int cnt = 1;
    for(int i = 1; i <= n; ++i) {
        int mineSize = v[i].size();
        if(mineSize % i != 0) {
            cout << IMPOSSIBLE << endl;
            return 0;
        }
        for(int j = 0; j < v[i].size(); ++j) {
            int factor = mineSize / i;
            int idx = v[i][j];
            result[idx] = cnt + j / i;
        }
        cnt += mineSize / i;
    }
    cout << POSSIBLE << endl;
    for(int item : result) cout << item << " ";
    cout << endl;
}
