#include <bits/stdc++.h>
using namespace std;

const int SZ = 1e5 + 1;
vector<int> arr[SZ];

ostream& operator<<(ostream& os, const vector<int> & v) {
	for (int item : v) os << item << ", ";
	return os;
}

class DVariousSushi {
public:
	void solve(istream& cin, ostream& cout) {
		ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
		cout.setf(ios::fixed); cout.precision(20);
		int n, k; cin >> n >> k;
		for (int i = 0; i < SZ; ++i) arr[i].clear();

		for (int i = 0; i < n; ++i) {
			int a, b; cin >> a >> b;
			arr[a].push_back(b);
		}

		for (int i = 0; i <= n; ++i) sort(arr[i].rbegin(), arr[i].rend());

		sort(arr, arr + n, [](const vector<int>& lhs, const vector<int>& rhs) {
			auto it1 = lhs.begin(), it2 = rhs.begin();
			while (it1 != lhs.end() && it2 != rhs.end()) {
				if (*it1 != *it2) return *it1 > *it2;
				++it1; ++it2;
			}
			if(it1 != lhs.end()) return true;
			return false;
		});


		/*auto comparator = [](const pair<int, list<int>>& lhs, const pair<int, list<int>>& rhs) {
			auto it1 = lhs.second.begin();
			auto it2 = rhs.second.begin();
			while (it1 != it2) {
				if (*it1 != *it2) return *it1 > *it2;
			}
			if (it1 != lhs.second.end()) return true;
			return false;
		};*/

		queue<vector<int>> remain;

		cout << endl;
		for (int i = 0; i <= n; ++i) {
			if (arr[i].size() == 0) continue;
			remain.push( arr[i] );
			cout << arr[i] << endl;
		}

		long long ans = 0;
		priority_queue<int> taken(remain.front().begin(), remain.front().end());
		remain.pop();
		ans = 1 + taken.top();
		taken.pop();
		long long K = 1; k--;

		while (not remain.empty() && k > 0) {
			long long soFar = ans + taken.top();

			long long newGuy = ans - K * K + (K + 1) * (K + 1) + remain.front().front();

			if (soFar >= newGuy) {
				ans = soFar;
				taken.pop();
			} else {
				ans = newGuy;
				for (int i = 1; i < remain.front().size(); ++i) {
					taken.push(remain.front()[i]);
				}
				remain.pop();
				++K;
			}
			--k;
		}
		cout << ans << endl;
	}
};
