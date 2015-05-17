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

bool visited[100][100];

int n, m;

int arr[5][5] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

void orthogonalDFS(int x, int y) {
	if (x >= n || y >= m || visited[x][y]) return;
	//if (arr[x][y] == 1) 
	visited[x][y] = true;
	if (x + 1 < n && arr[x + 1][y] == 1) orthogonalDFS(x + 1, y);
	if (x + 1 < n && y + 1 < m && arr[x + 1][y + 1] == 1) orthogonalDFS(x + 1, y + 1);
	if (x + 1 < n && y - 1 >= 0 && arr[x + 1][y - 1] == 1) orthogonalDFS(x + 1, y - 1);
	if (y + 1 < m && arr[x][y + 1] == 1) orthogonalDFS(x, y + 1);
	if (y - 1 >= 0 && arr[x][y - 1] == 1) orthogonalDFS(x, y - 1);
	if (x - 1 >= 0 && y + 1 < m && arr[x - 1][y + 1] == 1) orthogonalDFS(x - 1, y + 1);
	if (x - 1 >= 0 && y - 1 >= 0 && arr[x - 1][y - 1] == 1) orthogonalDFS(x - 1, y - 1);
	if (x - 1 >= 0 && arr[x - 1][y] == 1) orthogonalDFS(x - 1, y);
}

void numberOfIslands() {
	n = 5, m = 5;
	
	for (int i = 0; i < 100; i++) for (int j = 0; j < 100; j++) visited[i][j] = false;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) { 
			if (visited[i][j] == false && arr[i][j] == 1) {
				orthogonalDFS(i, j);
				ans++;
			}
		}
	}	
	cout << "Number of islands " << ans << endl;
}

int main() {
	numberOfIslands();
}