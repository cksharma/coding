#include "header.h"

int ReverseInteger::reverse(int x) {
	int tmp = abs(x);
	long long num = 0;
	while (tmp != 0) {
		int mod = tmp % 10;
		num = num * 10 + mod;
		tmp /= 10;
	}
	if (num > INT_MAX || num < INT_MIN)
		num = 0;
	else if (x < 0)
		num *= -1;
	return (int)num;
}

