#include <bits/stdc++.h>
#include <forward_list>
using namespace std;

void solve(int N) {
	queue<int> q;
	vector<int> v;
	int begin = 1;
	q.push(begin);
	while (q.empty() == false) {
		int curValue = q.front();
		q.pop();
		if (curValue > N)
			continue;
		v.push_back(curValue);
		for (int i = 0; i <= 9; i++) {
			int KK = curValue * 10 + i;
			if (KK > N) {
				continue;
			}
			q.push(KK);
		}
		if (q.size() == 0 && ++begin <= 9) {
			q.push(begin);
		}
	}
	for (int i = 0; i < (int)v.size(); i++) {
		cout << v[i] << endl;
	}
}

int main() {
	int N;
	cin >> N;
	solve(N);
}
