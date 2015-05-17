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
#include <queue>
using namespace std;

typedef long long LL;

const int c = (int) 1e7;

int * prime;
int visited[350][350];
int arr[350][350];

int N;

void init() {
	prime[0] = -1;
	prime[1] = -1;
	prime[2] = 1;
	for (int i = 2; i * i <= c; i++) {
		if (prime[i] == 1) {
			for (int j = i * i; j < c; j += i) {
				prime[j] = -1;
			}
		}
	}
}

void assignPrime() {
	int cnt = 0;
	for (int i = 0; i < c; i++) {
		if (prime[i] != -1) {
			prime[i] = cnt++;
			//cout << i << "  " << prime[i] << endl;
		}
	}
}

int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };

void recurse(int x, int y, int N, int parity) {
	
	for (int i = 0; i < 4; i++) {
		
		int x1 = x + dx[i];
		int y1 = y + dy[i];

		if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= N)
			continue;

		if (visited[x1][y1])
			continue;
		
		
		if (prime[arr[x1][y1]] == -1 && arr[x1][y1] % 2 == parity) {
			visited[x1][y1] = 1;
			recurse(x1, y1, N, parity);
		}
	}
	/*if (x - 1 >= 0 && !visited[x - 1][y] && prime[arr[x - 1][y]] == -1) {
	 visited[x - 1][y] = 1;
	 recurse(x - 1, y, N);
	 }
	 if (y - 1 >= 0 && !visited[x][y - 1] && prime[arr[x][y - 1]] == -1) {
	 visited[x][y - 1] = 1;
	 recurse(x, y - 1, N);
	 }
	 if (x + 1 < N && !visited[x + 1][y] && prime[arr[x + 1][y]] == -1) {
	 visited[x + 1][y] = 1;
	 recurse(x + 1, y, N);
	 }
	 if (y + 1 < N && !visited[x][y + 1] && prime[arr[x][y + 1]] == -1) {
	 visited[x][y + 1] = 1;
	 recurse(x, y + 1, N);
	 }
	 return;*/
}

int main() {

	prime = new int[c];
	fill(prime, prime + c, 1);
	init();
	assignPrime();

	int T;
	scanf("%d", &T);
	while (T-- > 0) {
		scanf("%d", &N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int r;
				scanf("%d", &r);
				arr[i][j] = r;
			}
		}
		LL ans = 0;

		for (int i = 0; i < N; i++)
			fill(visited[i], visited[i] + N, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 1)
					continue;

				visited[i][j] = 1;

				int k = arr[i][j];
				if (prime[k] != -1) {
					ans += (LL) prime[k];
					continue;
				}

				int parity = k % 2;
				if (parity == 1)
					ans += (LL) (k / 2 + 2);
				else
					ans += (LL) (k / 2);
				recurse(i, j, N, parity);
				/*queue <pair <int, int> > q;
				 q.push(make_pair(i, j));
				 while (q.size() > 0) {
				 pair <int, int> p = q.front();
				 q.pop();
				 int x = p.first;
				 int y = p.second;
				 
				 visited[x][y] = 1;
				 
				 if (x + 1 < N && arr[x + 1][y] % 2 == parity && visited[x + 1][y] == 0 && prime[arr[x + 1][y]] == -1)
				 q.push(make_pair(x + 1, y));
				 if (y + 1 < N && arr[x][y + 1] % 2 == parity && visited[x][y + 1] == 0 && prime[arr[x][y + 1]] == -1)
				 q.push(make_pair(x, y + 1));						
				 if (x - 1 >= 0 && arr[x - 1][y] % 2 == parity && visited[x - 1][y] == 0 && prime[arr[x - 1][y]] == -1)
				 q.push(make_pair(x - 1, y));
				 if (y - 1 >= 0 && arr[x][y - 1] % 2 == parity && visited[x][y - 1] == 0 && prime[arr[x][y - 1]] == -1)
				 q.push(make_pair(x, y - 1));
				 }	*/
			}
		}
		cout << ans << endl;
	}
}
