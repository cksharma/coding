#include <stdio.h>

typedef struct Points {
	int row, col;
} Points;

int n, m; 

int arr[101][101];

int path[101][101];

Points coordinates[201];

int i, j;

void input() {
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			int k;
			scanf("%d", &k);
			arr[i][j] = k;
		}
	}
}

int solveGrid(int x, int y) {

	if (x == n - 1 && y == m - 1)
		return path[x][y] = 1;

	if (!arr[x][y]) {
		return path[x][y] = 0;;
	} 
	
	int a = 0, b = 0;

	if (x + 1 < n && arr[x + 1][y] == 1) {
		a = solveGrid(x + 1, y);
	}
	if (y + 1 < m && arr[x][y + 1] == 1) {
		b = solveGrid(x, y + 1);
	}
	return path[x][y] = a || b;
}

void fillPathArray() {
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			path[i][j] = 0;
		}
	}
	path[0][0] = 1;
}

void printPath() {
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			printf("%d  ", path[i][j]);
		}
		printf("\n");
	}
}

void printCoordinates() {
	for (i = 0; i < n + m - 1; i++) {
		Points p = coordinates[i];
		printf("(%d, %d)\n", p.row, p.col);
	}
}

void storeCoordinates() {
	i = 0, j = 0;
	int index = 0;
	while (i < n && j < m) {

		if (path[i][j] == 1) {
			Points p;
			p.row = i;
			p.col = j;
			coordinates[index++] = p;
		}

		if (i == n - 1 && j == m - 1)
			break;

		if (i + 1 < n && path[i + 1][j] == 1)
			i++;
		else {
			if (j + 1 < m)
				j++;
		}

	}
}

int main() {

	n = 100, m = 100; // You can make them 100 and 100 also. 
	//n is number of rows.
	//m is number of cols.
	
	input(); // Give the input for 2-D array.
	
	printf("\n\n");

	fillPathArray(); // fill the path array. Initially (0, 0) is 1. All others 0.

	solveGrid(0, 0); // Main logic written here.

	storeCoordinates(); // Store the coordinates in data structures.
	
	printf("PATH ARRAY IS :\n\n");
	printPath();  // Print the Unique path from (0, 0) to (n - 1, m - 1)

	printf("\n\n");

	printf("PATH COORDINATES ARE : \n\n");
	printCoordinates();  //Print all the coordinates of the path
}