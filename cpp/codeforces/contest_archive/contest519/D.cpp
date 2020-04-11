#include <bits/stdc++.h>
using namespace std;

long long getNumber(int n) {
    return ( 1LL * n * (n + 1LL) ) / 2LL;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    int permutations[m][n];
    int positions[m][n];

    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            int val; cin >> val;
            permutations[i][j] = val;
            positions[i][val] = j;
        }
    }

    long long ans = n; bool found = true;
    int col = 1, prev = permutations[0][0], len = 0;
    while( col < n )
    {
        int firstVal = permutations[0][col];
        for(int row = 1; row < m; ++row) {
            int index = positions[row][firstVal];
            int myVal = permutations[row][index];
            if( firstVal != myVal || index <= 0 || prev != permutations[row][index-1] ) {
                found = false;
                break;
            }
        }
        if( found ) {
            len++;
        } else {
            ans += getNumber( len );
            len = 0;
            found = true;
        }
        prev = firstVal;
        col++;
    }
    if( len >  0) ans += getNumber( len );
    cout << ans << endl;
}