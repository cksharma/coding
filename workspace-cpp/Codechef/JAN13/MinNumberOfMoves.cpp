#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int T;
	cin >> T;
	int N;
	while (T-- > 0) {
		cin >> N;
		int * arr = new int[N];
		for (int i = 0; i < N; i++) 
			cin >> arr[i];
		sort(arr, arr + N);
		
		int * A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = arr[N - 1] - arr[i];
		}
		
		int ans = 0;
		for (int i = 1; i < N; i++) {
			ans += A[0] - A[i];
		}
		cout << ans << endl;
	}
}
