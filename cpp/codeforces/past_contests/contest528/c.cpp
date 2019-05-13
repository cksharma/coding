#include <bits/stdc++.h>
using namespace std;

struct Plot {
    int x, y;

    bool operator<( const Plot& rhs ) const {
        if( x != rhs.x ) return x < rhs.x;
        return y < rhs.y;
    }
};

int main()
{
    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;
    vector<Plot> plots = { {a, b}, {c, d}, {e, f} };
    sort( plots.begin(), plots.end() );

    set<Plot> path;
    Plot A = plots[0];
    Plot B = plots[1];
    Plot C = plots[2];
    for(int i = A.x; i <= B.x; ++i) path.insert( {i, A.y} );
    for(int i = min(A.y, B.y); i <= max(A.y, B.y); ++i) path.insert( {B.x, i} );

    int distance = INT_MAX;
    Plot bestPlot;

    for(const Plot& plot : path) {
        int absDis = abs( C.x - plot.x ) + abs( C.y - plot.y );
        if( absDis < distance ) {
            distance = absDis;
            bestPlot = plot;
        }
    }

    for(int i = bestPlot.x; i <= C.x; ++i) path.insert( {i, bestPlot.y} );
    for(int i = min(bestPlot.y, C.y); i <= max(bestPlot.y, C.y); ++i) path.insert( {C.x, i} );

    cout << path.size() << endl;
    for(auto& p : path) {
        cout << p.x << " " << p.y << endl;
    }
}
