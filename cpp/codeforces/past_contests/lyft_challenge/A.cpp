#include <bits/stdc++.h>
int main()
{
    int n, ax, ay, bx, by, cx, cy;
    std::cin >> n >> ax >> ay >> bx >> by >> cx >> cy;

    bool xIntersect = ax < std::max(bx, cx) && ax > std::min(bx, cx);
    bool yIntersect = ay < std::max(by, cy) && ay > std::min(by, cy);

    std::cout << ( ( xIntersect || yIntersect ) ? "NO" : "YES" ) << std::endl;
    return 0;
}