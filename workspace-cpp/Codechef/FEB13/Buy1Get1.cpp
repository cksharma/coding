#include <iostream>
#include <cstdio>
#include <map>
using namespace std;

int main() {
	int T;
	cin >> T;
	string s;
	int ans;
	while (T--) {
		ans = 0;
		cin >> s;
		map<char, int> mp;
		map<char, int>::iterator it;
		for (int i = 0; i < s.length(); i++) {
			mp[s.at(i)]++;
		}
		for(it = mp.begin(); it != mp.end(); it++) {
			ans += (it->second + 1) / 2;
		}
		cout << ans << endl;
	}
}



