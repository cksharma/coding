#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    vector<int> riders(n);
    vector<int> drivers(m);
    
    vector<int> input(n + m );
    for(int i = 0; i < n + m; i++) cin >> input[i];

    int ri = 0, di = 0;
    for(int i = 0; i < n + m; i++) {
        int who; cin >> who;
        if( who == 0 ) riders[ri++] = input[i];
        else drivers[ di++ ] = input[i];
    }
    
    //sort( riders.begin(), riders.end() );
    //sort( drivers.begin(), drivers.end());
    
   // for(int item : riders ) cout << item << "  ";
   // cout << endl;
   // for(int item : drivers ) cout << item << " ";
   // cout << endl;
    
    vector<int> result(m, 0);
    for(di = 0, ri = 0; di < m && ri < n; di++) {
        while( ri < n && riders[ri] <= drivers[di] ) {
            result[di]++;
            ri++;
        }
        while( di + 1 < m && ri < n && riders[ri] > drivers[di] && riders[ri] < drivers[di + 1] ) {
            if( riders[ri] - drivers[di] <= drivers[di + 1] - riders[ri] ) {
                result[di]++;    
            } else {
                result[di + 1]++;
            }
            ri++;
        }        
    }    

    while( ri < n && riders[ri] >= drivers[m - 1] ) {
        result[ m - 1]++;
        ri++;
    } 
    for(int i = 0; i < m; i++) {
        cout << result[i] << " ";
    }
    cout << "\n";
    return 0;
}

