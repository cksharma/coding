#include "header.h"

long long getLong(int x) {
	long long ans = 0;
	while (x != 0) {
		int md = x % 10;
		ans = ans * 10 + md;
		x /= 10;
	}
	return ans;
}

bool PalindromeNumber::isPalindrome(int x) {
	if (x < 0) return false;
	long long ans = getLong(x);
	return ans == x;
}

