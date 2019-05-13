#include <bits/stdc++.h>
using namespace std;

template<typename Container, typename Index>
decltype(auto) elementType(Container& c, Index index)
{
    return c[index];
}

template<typename Container, typename Index>
auto elementTypeCpp11(Container& c, Index index) -> decltype(c[index])
{
    return c[index];
}

int main()
{
    vector<int> v = {1, 2, 3, 4, 5, 6, 7 };
    cout << elementType< vector<int>, int>(v, 5) << endl;
    cout << elementTypeCpp11( v, 4 ) << endl;
    return 0; 
}