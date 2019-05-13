#include <bits/stdc++.h>
using namespace std;

struct Horizontal {
    int x1;
    int x2;
    int y;
    Horizontal(int a, int b, int c) : x1(a), x2(b), y(c) {} 

    bool operator<(const Horizontal& rhs) const {
        return x2 < rhs.x2;
    }
};

struct Vertical {
    int x;    
    Vertical(int a) : x(a){}
    
    bool operator< (const Vertical& rhs) const {
        return x < rhs.x;
    }
};

int main() {
    int n, m;
    cin >> n >> m;
    vector<Vertical> vert;
    vector<Horizontal> hori;
    
    int all_horiz = 0;
    
    for(int i = 0; i < n; ++i) {
        int a; cin >> a;
        vert.emplace_back( a ); 
    }
    vert.emplace_back( (int)1e9 + 1 );
    sort( vert.begin(), vert.end() );
    
    for(int i = 0; i < m; i++) {
        int x1, x2, y;
        cin >> x1 >> x2 >> y;
        if( x1 == 1 && x2 == (int)1e9 ) {
            all_horiz++;
        } else if( x1 == 1 ) {
            hori.emplace_back( x1, x2, y );
        } 
    }
    
    sort( hori.begin(), hori.end() );
    
    int ans = INT_MAX;
    
    for(int i = 0; i < vert.size(); i++) {
        int x = vert[i].x; Horizontal hor { 1, x - 1, 0 };
        int dis = distance( upper_bound( hori.begin(), hori.end(), hor ), hori.end() ) + i;
        ans = min( ans, dis );
    }
 
    cout << ( ans == INT_MAX ? 0 : ans ) + all_horiz << endl;
    return 0;
}