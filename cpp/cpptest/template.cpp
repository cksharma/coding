#include <bits/stdc++.h>
using namespace std;

template <typename Vector>
auto getFirstElementCpp14_17_1(const Vector& v) {
    return v[0];
}

template <typename Vector>
auto getFirstElementCpp11(const Vector& v) -> decltype(v[0])
{
    return v[0];
}

template <typename Vector>
decltype(auto) getFirstElementCpp14_17_2( const Vector& v) {
    return v[0];
}

int main()
{
    vector<string> v = {"Chandra", "Kant", "Sharma"};
    cout << getFirstElementCpp11(v) << endl;
    cout << getFirstElementCpp14_17_1(v) << endl;
    cout << getFirstElementCpp14_17_2(v) << endl;
}