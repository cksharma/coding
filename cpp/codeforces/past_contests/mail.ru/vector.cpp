#include <bits/stdc++.h>
using namespace std;

template<typename Container, typename Index>
decltype(auto) getItem(Container& c, Index i) {
    return c[i];
}

template<typename Container, typename Index>
auto getItemBefore(Container& c, Index i) {
    return c[i - 1];
}

int main()
{
    vector<int> v(4, 400);
    cout << getItem(v, 0) << endl;
    cout << getItemBefore( v, 1 ) << endl;
    return 0;
}