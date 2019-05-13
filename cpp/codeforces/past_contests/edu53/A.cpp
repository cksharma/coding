#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	string str;
	cin >> str;
	for(int i = 0; i < str.size() - 1; ++i) {
		if(str[i] != str[i + 1]) {
			cout << "YES" << endl;
			cout << str[i] << str[i + 1] << endl;
			return 0;
		}
	}
	cout << "NO" << endl;
	return 0;
}