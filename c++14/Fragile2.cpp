#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int ans = 0;

bool visited[21][21];
void findPairs(vector <string> &v, int start, int to, int cnt) {
	if (visited[start][to]) {
		if (cnt <= 3) return;
		ans += (cnt - 3) * (cnt - 1);
		return;
	}
	visited[start][to] = true;
	for (int col = 0; col < v.size(); col++) {
		if (!visited[start][col] && start != col) 
			findPairs(v, start, col, cnt + 1);
	}
}

int main() {
	int n;

	cin >> n;
	for (int i = 0; i < 21; i++) for (int j = 0; j < 21; j++) visited[i][j] = false;
	vector <string> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	for (int start = 0; start < n; start++) {
		findPairs(v, start, 0, 1);
	}	
	cout << ans << endl;
}
