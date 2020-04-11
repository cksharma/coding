#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	vector<int> Stack(n);
	vector<int> Steps(n);
	for(int i = 0; i < n; ++i) {
		cin >> Stack[i];
	}
	for(int i = 0; i < n; ++i) {
		cin >> Steps[i];
	}
	int index = 0;
	unordered_set<int> visited;
	for(int i = 0; i < Steps.size(); ++i) {
		int target = Steps[i];
		if( visited.find(target) != visited.end()) {
			cout << "0 ";
			continue;
		}
		int cnt = 0;
		index = visited.size();
		while(index < Stack.size()) {
			visited.insert( Stack[index]);
			cnt++;			
			if( Stack[index] == target) break;
			index++;
		}
		cout << cnt << " ";
	}
	return 0;
}