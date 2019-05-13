#include <bits/stdc++.h>

int f[26][26][26][26];

int main()
{
    f[12][12][12][12] = 12;
    int& val = f[12][12][12][12];
    std::memset( f, 255, sizeof(f));
    std::cout << val << std::endl;
    return 0;
}