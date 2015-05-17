#include <iostream>
#include <cstdio>
using namespace std;

int arr[1000001];

const int MD = 1000000007;

void init() {
	int f = 1;
	int s = 2;
	arr[1] = f;
	arr[2] = s;
	
	for (int i = 3; i < 1000001; i++) {
		arr[i] = arr[i - 1] + arr[i - 2];
		arr[i] %= MD;
	}	
}

int countBits(int num) {
	int ans = 0;
	while (num > 0) {
		num = num & (num - 1);
		ans++;
	}
	return ans;
}

int main() {
	init();
	int T;
	cin >> T;
	int N, G;
	while (T--) {
		cin >> N >> G;
		int num = arr[N];
		if (countBits(num) == G) {
			cout << "CORRECT" << endl;
		} else {
			cout << "INCORRECT" << endl;
		}
	}
}
