#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    int H, N;
    cin >> H >> N;
    int sum = 0;
    for (int i = 0; i < N; ++i) {
        int num; cin >> num;
        sum += num;
    }
    cout << (sum >= H ? "YES" : "NO") << endl;
}
