#include <bits/stdc++.h>
using namespace std;

struct Rectangle {
    long long x1, y1, x2, y2;
    Rectangle(long long a, long long b, long long c, long long d ) {
        x1 = min(a, c);
        x2 = max(a, c);
        y1 = min(b, d);
        y2 = max(b, d);
    }

    Rectangle() {}

    long long getArea() {
        return abs(x2 - x1 + 1) * abs( y2 - y1 + 1);
    }
    
    bool whiteSeed() {
        return (x1 + y1) % 2 == 0;
    }

    long long blackCount() {
        long long area = getArea();
        if( whiteSeed() ) {
            return area / 2;
        }
        return ( area + 1 ) / 2;
    }

    long long whiteCount() {
        return getArea() - blackCount();
    }
};

ostream& operator<<( ostream& os, const Rectangle& r) {
    os << r.x1 << ", " << r.y1 << ", " << r.x2 << ", " << r.y2;
    return os;
}

bool doesIntersect( Rectangle& lhs, Rectangle& rhs, Rectangle& intersect ) {
    long long x1 = max(lhs.x1, rhs.x1);
    long long y1 = max(lhs.y1, rhs.y1);
    long long x2 = min(lhs.x2, rhs.x2);
    long long y2 = min(lhs.y2, rhs.y2);

    if( (x1 > x2 or y1 > y2) ) { return false; }

    intersect = Rectangle( x1, y1, x2, y2 );
    return true;
}

int main()
{
    long long t, n, m;
    long long x1, y1, x2, y2, x3, y3, x4, y4;
    cin >> t;
    while( t-- > 0 ) {
        cin >> n >> m >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4;
        Rectangle white( x1, y1, x2, y2 );
        Rectangle black( x3, y3, x4, y4 );
        long long wcount = (n * m + 1) / 2;

        wcount += white.blackCount();
        wcount -= black.whiteCount();

        Rectangle intersect;
        if ( doesIntersect( white, black, intersect ) ) {
            wcount -= intersect.blackCount(); 
        }
        cout << wcount << " " << (n * m - wcount) << endl;
    }
    return 0;
}