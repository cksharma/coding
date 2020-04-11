#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    int N, K;
    cin >> N >> K;
    
    vector<tuple<int, int, int>> vtiii;
    for (int i = 0; i < N; ++i) {
        int x, y, c;
        cin >> x >> y >> c;
        tuple t = {x, y, c};
        vtiii.emplace_back(t);
    }
    for (auto& t : vtiii) {
       cout << get<0>(t) << ", " << get<1>(t) << ", " << get<2>(t) << "\n"; 
    }
}
