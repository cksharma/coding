#include <iostream>
#include <cstdio>
using namespace std;

typedef long long LL;

int arr[1001];
int N;
const int MD = 1000000007;

int dp[1001][1001];

int nCr(int n, int r) {
	if (n == r)
		return dp[n][r] = 1;
	if (r == 0)
		return dp[n][r] = 1;
	if (r == 1)
		return (dp[n][r] = n) % MD;
	if (dp[n][r])
		return dp[n][r] % MD;
	return dp[n][r] = ((nCr(n - 1, r) % MD)  + (nCr(n - 1, r - 1) % MD )) % MD;
}

void init() {
	for (int i = 0; i < 1001; i++) 
		for (int j = 0; j < 1001; j++)
			dp[i][j] = 0;
	for (int i = 1000; i >= 0; i--)
		nCr(1000, i);
}

int main() {
	
	init();
	
	int T;
	cin >> T;	
	while (T--) {
		cin >> N;
		int ans = 0;
		for (int i = 0; i < N; i++) 
			cin >> arr[i];
		if (N == 1) ans++;
		else {
			for (int i = N; i > N / 2; i--) {
				ans += dp[N][i];
				ans %= MD;
			}
		}
		cout << ans << endl;			
	}
}
