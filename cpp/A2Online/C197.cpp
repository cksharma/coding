#include <bits/stdc++.h>
using namespace std;

struct state {
	int prev;
	int leftsum;
	int rightsum;
	state(int prev, int leftsum, int rightsum) : prev(prev), leftsum(leftsum), rightsum(rightsum) {}

	string to_string() const {
		return "[" + std::to_string(prev) + ", " + std::to_string(leftsum) + ", " + std::to_string(rightsum) + "]";
	}
	bool operator < (const state& s) const {
		if (prev != s.prev) return prev < s.prev;
		if (leftsum != s.leftsum) return leftsum < s.leftsum;
		return rightsum < s.rightsum;
	}
	bool operator == (const state& s1) const {
		return s1.prev == prev && s1.leftsum == leftsum && s1.rightsum == rightsum;
	}
};

struct hashfunction {
	bool operator () (const state& s) const {
		return hash<int>()(s.prev) + hash<int>()(s.leftsum) + hash<int>()(s.rightsum);
	}
};

int n;
string str;
unordered_map<state, bool, hashfunction> cache;
vector<int> res;

void printvector(vector<int> &v) {
	cout << "Size :" << v.size() << " ::: ";
	for (auto &i : v) cout << i << " ";
	cout << endl;
}

void printmap() {
	cout << "Printing Map" << endl;
	for (auto &item : cache) {
		cout << "(" << item.first.to_string() << ", " << item.second << "), ";
	}
	cout << endl;
}

bool dfs(int leftsum, int rightsum, vector<int> &v) {
	if (v.size() == n) return true;
	
	//printvector(v);

	int prev = v.size() > 0 ? v[v.size() - 1] : 0;

	state state(prev, leftsum, rightsum);
	
	if (cache.count(state) > 0) {
		//cout << state.to_string() << endl;
		//printmap();
		return cache[state];
	}
	bool leftturn = v.size() % 2 == 0;

	bool cando = false;
	
	for (int i = 0; i < res.size() && !cando; i++) {
		
		int item = res.at(i);

		if (leftturn && prev != item && leftsum + item > rightsum) {
			v.push_back(item);
			cando = dfs(leftsum + item, rightsum, v);
			if (!cando && v.size() > 0) v.erase(v.end() - 1); 
		} else if ( !leftturn && prev != item && rightsum + item > leftsum ) {
			v.push_back(item);
			cando = dfs(leftsum, rightsum + item, v);
			if (!cando && v.size() > 0) v.erase(v.end() - 1);
		}
	}
	cache.insert(make_pair(state, cando));
	return cando;
}

int main() {
	std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> str;
    cin >> n;

    vector<int> v;
    for (int i = 0; i < str.length(); i++) {
    	if (str.at(i) != '0') res.push_back(i + 1);
    }

    //printvector(res);

    if (dfs(0, 0, v)) {
    	cout << "YES" << endl;
    	for (auto &item : v) cout << item << " ";
    	cout << endl;
    } else {
    	cout << "NO" << endl;
    }
}
