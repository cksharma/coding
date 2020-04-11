#include <bits/stdc++.h>
using namespace std;

struct Coordinate {
    int x;
    int y;
    Coordinate(int x, int y) : x(x), y(y) {}

    bool operator<(const Coordinate& c) const {
        if( x != c.x) return x < c.x;
        return y < c.y;
    }
    Coordinate() {}
};

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    int n, x, y; cin >> n;
    vector< Coordinate > obelisks(n);
    vector< Coordinate > clues(n);

    for(int i = 0; i < n; ++i) {
        cin >> x >> y;
        obelisks[i] = Coordinate( x, y );
    }
    for(int i = 0; i < n; ++i) {
        cin >> x >> y;
        clues[i] = Coordinate( x, y );
    }
    sort( obelisks.begin(), obelisks.end());
    sort( clues.begin(), clues.end());

    cout << clues[n - 1].x + obelisks[0].x << " "
         << clues[n - 1].y + obelisks[0].y << endl;
}
