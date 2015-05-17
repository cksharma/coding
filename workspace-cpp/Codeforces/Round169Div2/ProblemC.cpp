#include <vector>
#include <map>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <string.h>
#include <set>
#include <climits>
#include <sstream>
#include <iostream>

using namespace std;

typedef long long LL;

int main() {
	int n, k;
	cin >> n >> k;
	int *arr = new int[n];
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	sort(arr, arr + n);
	set <LL> visited;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		LL num = (LL)arr[i] * (LL)k;
		if (visited.find((LL)arr[i]) != visited.end()) 
			continue;
		ans++;
		visited.insert(num);
	}
	cout << ans << endl;
}