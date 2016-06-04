#include <bits/stdc++.h>
using namespace std;

//C++ sucks in many angles. Why the fuck C++ cannot be as efficient and consistent as Java.
//Why the fuck is cout so so slow... never ever use cout for printing

bool cmp (const pair<int, int> &first, const pair<int, int> &second) {
	int d1 = abs(first.first) + abs(first.second);
	int d2 = abs(second.first) + abs(second.second);
	return d1 < d2;
}

char getDirectionX(int x) {
	if (x < 0) return 'L';
	if (x > 0) return 'R';
	throw invalid_argument("invalid choice");
}

char getDirectionY(int y) {
	if (y < 0) return 'D';
	if (y > 0) return 'U';
	throw invalid_argument("invalid choice");
}

void directions(vector<pair <int, int>> &bombs) {	
	
	for (auto &bomb : bombs) {
		int x = bomb.first;
		if (x != 0) {
			char xdir = getDirectionX(x);
			printf("%d %d %c\n", 1, abs(x), xdir);
			//cout << "1 " << abs(x) << " " << xdir << endl;
		}
		
		int y = bomb.second;
		if (y != 0) {
			char ydir = getDirectionY(y);
			printf("%d %d %c\n", 1, abs(y), ydir);
			//cout << "1 " << abs(y) << " " << ydir << endl;
		}
		printf("%d\n", 2);
		if (x != 0) {
			char xdir = getDirectionX(x) == 'L' ? 'R' : 'L';
			printf("%d %d %c\n", 1, abs(x), xdir);
			//cout << "1 " << abs(x) << " " << xdir << endl;
		}
		if (y != 0) {
			char ydir = getDirectionY(y) == 'U' ? 'D' : 'U';
			printf("%d %d %c\n", 1, abs(y), ydir);
			//cout << "1 " << abs(y) << " " << ydir << endl;
		}
		printf("%d\n", 3);
		//cout << 3 << endl;
	}
}

int main() {
	
	int n, x, y;
	cin >> n;

	vector<pair<int, int>> bombs;
	int steps = 0;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		bombs.push_back(make_pair(x, y));
		steps += 2 + (x != 0 ? 2 : 0)+ (y != 0 ? 2 : 0);
	}
	sort(bombs.begin(), bombs.end(), cmp);

	//cout << steps << endl;
	printf("%d\n", steps);
	
	directions(bombs);
}