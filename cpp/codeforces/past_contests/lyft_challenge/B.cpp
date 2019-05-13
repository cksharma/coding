#include <bits/stdc++.h>

bool isPrime( long long a ) {
    for(long long i = 2; i * i <= a; ++i) {
        if( a % i == 0 ) return false;
    }
    return true;
}

int main() {
    int t;
    long long a;
    long long b;
    std::string ans;

    std::cin >> t;
    while(t-- > 0) {
        std::cin >> a >> b;

        if( a - b > 1 ) {
            ans = "NO";
        }
        else if( isPrime( a + b )) {
            ans = "YES";
        } else {
            ans = "NO";
        }
        std::cout << ans << std::endl;
    }
}