#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

typedef long long LL;

const int MD = 1000000007;

int main() {
	int T;
	cin >> T;
	while (T-- > 0) {
		LL arr[3];
		cin >> arr[0] >> arr[1] >> arr[2];
		sort(arr, arr + 3);
		LL ans = arr[0];
		ans = ((ans % MD )* ((arr[1] - 1) % MD)) % MD;
		ans = (ans * ((arr[2] - 2) % MD)) % MD;
		cout << ans << endl;
	}
}
