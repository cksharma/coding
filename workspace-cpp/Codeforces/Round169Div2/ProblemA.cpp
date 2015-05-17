#include <iostream>
#include <cstdio>
#include <climits>
using namespace std;

int main() {
	int n, k;
	cin >> n >> k;
	int ans = INT_MIN;
	for (int i = 0; i < n; i++) {
		int f, t;
		cin >> f >> t;
		int joy = f;
		if (t > k) {
			joy = f - (t - k);
		} 
		ans = max(ans, joy);
	}
	cout << ans << endl;
}