#include <bits/stdc++.h>
using namespace std;

template< typename T>
concept floating_number = is_floating_point_v<T>;

template <typename Float>
auto add(Float f1, Float f2) {
    return f1 + f2;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
}
