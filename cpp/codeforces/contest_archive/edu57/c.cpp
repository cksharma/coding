#include <bits/stdc++.h>
using namespace std;

void print(map<int, set<int>>& mp) {
    for(auto& p : mp) {
        cout << "Side : " << p.first << "= ";
        for(auto t : p.second) {
            cout << t << ", ";
        }
        cout << endl;
    }
}

bool notFlat(int angle, int n) {
    return not ( angle * n == (n - 2) * 180);
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int T; cin >> T;
    vector<int> input;
    while(T-- > 0) {
        int ang; cin >> ang;
        input.push_back( ang );

        bool ok = false;
        for(int i = 3; i <= 180; ++i) {
            int total = (i) * ang;
            if ( total % 180 == 0) {
                if( ang >= 90 && notFlat( ang, i ) ) cout << min(2 * i, 180) << endl;
                else cout << i << endl;
                ok = true;
                break;
            }
        }
        if( ok == false ) cout << -1 << endl;
    }

    return 0;
    map<int, set<int>> mp;
    for(int n = 3; n < 180; ++n) {
        int total = (n - 2) * 180;

        if( ( total) % n == 0) {
            int oneAng = (total) / n;
            int otherTwoSum = 180 - oneAng;
            if ( otherTwoSum % 2 == 0 && otherTwoSum > 0) {
                int take = otherTwoSum / 2;
                while ( take < 180 ) {
                    mp[n].insert( take );
                    take += otherTwoSum / 2;
                }
            }
        } else {
            int gcd = __gcd(total, n );
            int oneAng = (gcd * total) / n;
            int otherTwoSum = 180 - oneAng;
            if ( otherTwoSum % 2 == 0 && otherTwoSum > 0) {
                int take = otherTwoSum / 2;
                while ( take < 180 ) {
                    mp[n].insert( take );
                    take += otherTwoSum / 2;
                }
            }
        }
    }

    //print(mp);

    for(int ang : input) {
        bool found = false;
        for(auto& p : mp) {
            if( p.second.find(ang) != p.second.end()) {
                cout << (ang > 90 ? p.first * 2 : p.first) << endl;
                found = true;
                break;
            }
        }
        if(found == false) cout << -1 << endl;
    }

    return 0;
}
