#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);cout.precision(16);
    int n, s;
    cin >> n >> s;
    map<int, int> graph;
    for(int i = 0; i < n - 1; ++i) {
        int a, b;
        cin >> a >> b;
        graph[a]++;
        graph[b]++;
    }
    int leaf = 0;
    for(auto& [key, val] : graph) {
        if( val == 1) leaf++;
    }

    cout << ( 2. * s ) / leaf << endl;
    return 0;
}