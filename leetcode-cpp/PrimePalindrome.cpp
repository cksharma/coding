#include <bits/stdc++.h>

bool isPalin(int num) {
	int factor = 1;
	int n = num;
	int res = 0;
	while(n > 0 ) {
		res = res * 10 + n % 10;
		n/= 10;
	}
	return res == num;
}

void compute(int n) {
	bool prime[n];
	std::fill(prime, prime + n, true);
	prime[1] = false;
	for(int i = 2; i * i <= n; ++i) {
		if(prime[i]) {
			for (int j = i * i; j <= n; j += i) {
				prime[j] = false;
			}
		}
	}
	for(int i = 2; i <= n; ++i) {
		if( prime[i] && isPalin(i) ) {
			std::cout << i << ", ";
		}
	}
}

class Solution {
  public:
    int primePalindrome(int N) {

    }
};

int main() {
	compute( (int)1e6 );
    return 0;
}
