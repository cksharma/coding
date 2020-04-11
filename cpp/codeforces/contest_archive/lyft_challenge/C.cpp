#include <bits/stdc++.h>

const int MAX = 100001;
bool dp[MAX];

std::vector<int> vec;
int n;
std::string ans;

bool canAliceWin(int index, int steps) {
    bool good = false;
    for(int sign = -1; sign <= 1; sign += 2 ) {
        int factor = sign * num;
        for(int k = index + factor; k >= 0 && k < n; k += factor ) {
            if( vec[k] > vec[index] ) {
                canAliceWin( k, step + 1 );
                good = true;
            }
        }
    }
    return good;
}

int main() {
    std::fill(dp, dp + 100001, false);
    std::cin >> n;
    vec.reserve(n);
    for(int i = 0; i < n; ++i) std::cin >> vec[i];
    for(int i = 0; i < n; ++i) {
        if( canAliceWin(i, 0) ) ans += "A";
        else ans += "B";
    }
    std::cout << ans << std::endl;
}