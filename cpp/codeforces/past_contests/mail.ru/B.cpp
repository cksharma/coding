#include <bits/stdc++.h>
using namespace std;

struct Segment {
    long long low;
    long long high;

    bool operator<(const Segment& seg) const {
        return low <= seg.low && high <= seg.high;
    }
    Segment( int lo, int hi) : low(lo) , high(hi) {}
};

ostream& operator<<(ostream& os, const Segment& seg) {
    os << "{" << seg.low << ", " << seg.high << "}";
    return os;
}

set<Segment> segments;

void mergeSegment( Segment& newSeg ) {
    int cnt = 0;
    auto it = segments.upper_bound( newSeg );
    auto prv = segments.end();
    prv = it != segments.end() ? prev( it ) : segments.end();

    if ( it != segments.end() && prv != segments.end() ) {
        if( newSeg.low <= it->low && newSeg.low >= prv->low ) {
            segments.erase( it );
            segments.erase( prv );
            segments.insert( Segment( prv->low, it->high ) );
            return;
        }
    }

    if ( it != segments.end() ) {
        Segment lhs = *it;
        //cout << "LHS " << lhs << endl;
        if( lhs.low <= newSeg.low && lhs.high >= newSeg.high ) {
            // no-op;
        } else if ( lhs.low == newSeg.high + 1 ) {
            lhs.low = newSeg.low;
            segments.erase(it);
            segments.insert( lhs );
        } else {
            segments.insert( newSeg );
        }
        cnt++;
    }

    auto it1 = segments.lower_bound( Segment( newSeg.low - 1, newSeg.high - 1 ) );
    if( it1 != segments.end() ) {
        Segment rhs = *it1;
       // cout << "RHS " << rhs << endl;
        if ( rhs.low <= newSeg.low && rhs.high >= newSeg.high ) {
            // no-op
        } else if( rhs.high + 1 == newSeg.low ) {
            rhs.high = newSeg.high;
            segments.erase( it1 );
            segments.insert( rhs );
        } else {
            segments.insert( newSeg );
        }
        cnt++;
    }

    if( it != segments.end() && it1 != segments.end() ) {
        Segment lhs = *it;
        Segment rhs = *it1;
        if( lhs.low == rhs.high + 1 ) {
            segments.erase( it );
            segments.erase( it1 );
            segments.insert( Segment( rhs.low, lhs.high ) ); }
            cnt++;

    }
    if( cnt == 0 ) segments.insert( newSeg );
}

void printSegments() {
    for( auto it = segments.begin(); it != segments.end(); ++it) {
        cout << "( " <<  it->low << ", " << it->high << " )";
    }
    cout << endl;
}

int main()
{
    segments.clear();
    long long n, m, l; cin >> n >> m >> l;
    vector<long long> a(n + 1);

    for(int i = 1; i <= n; ++i) {
        cin >> a[i];
        if( a[i] > l ) {
            Segment newSeg( i, i );
            mergeSegment( newSeg);
        }
    }

    for(int i = 0; i < m; ++i) {
        int flag;
        cin >> flag;
        if( flag == 0 ) {
            //printSegments();
            cout << segments.size() << endl;
        } else {
            long long p, d;
            cin >> p >> d;
            if( a[p] + d > l ) {
                Segment newSeg( p, p );
                mergeSegment( newSeg );
            }
            a[p] += d;
        }
    }
    return 0;
}