#include <bits/stdc++.h>

int main()
{
    std::vector< int> v{1, 2, 3, 4, 5, 6 };
    int x = 5;
    v.erase( std::remove_if( v.begin(), v.end(), [x](int k) { return k > 5; } ) );
    std::for_each( v.begin(), v.end(), [](int item) {
       std::cout << item << ", "; 
    });
    return 0;
}