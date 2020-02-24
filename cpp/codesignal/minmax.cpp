#include <bits/stdc++.h>
using namespace std;

void minmax_vector()
{
    vector<int> v { 5, 2, 9, 11, 1, 3, 7};
    auto p = minmax_element(v.begin(), v.end());
    cout << "Min Element is " << *(p.first) << " at position " << p.first - v.begin() << endl;
    cout << "Max Element is " << *(p.second) << " at position " << p.second - v.begin() << endl;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    minmax_vector();
}
