#include <bits/stdc++.h>
using namespace std;

array<int, 4> dx = {-1, 0, 0, 1};
array<int, 4> dy = {0, -1, 1, 0};

int n, m ,k;
const int N = 505;
const int M = 505;

char ch[N][M];

void dfs(int x, int y, bool visited[N][M]) {
	if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || k <= 0) return;
	if (ch[x][y] == 'X' || ch[x][y] == '#') return;

	visited[x][y] = true;
	
	bool cantake = true;
	for (int i = 0; i < dx.size(); i++) {
		int x1 = dx[i] + x;
		int y1 = dy[i] + y;
		if (x1 >= n || y1 >= m || x1 < 0 || y1 < 0 || visited[x1][y1]) continue;
		if (ch[x1][y1] == 'X' || ch[x1][y1] == '#') continue;
		cantake = false;
		dfs(x1, y1, visited);		
	}
	if (k != 0) {
		ch[x][y] = 'X';
		k--;
	}
	
	//visited[x][y] = false;
}

int main() {
	
	scanf("%d", &n);
	scanf("%d", &m);
	scanf("%d", &k);
	for (int i = 0; i < n; i++) {
		scanf("%s", ch[i]);
	}

	bool visited[N][M];
	for (int i = 0; i < n; i++)	fill(visited[i], visited[i] + m, false);

	int x, y;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (ch[i][j] == '.') {
				x = i; y = j;
				goto down;
			}
		}
	}
	
	down:;

	dfs(x, y, visited);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			putchar(ch[i][j]);
		}
		puts("");
	}

}