#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	string s;
	cin >> s;
	int * arr = new int[26];
	for (int i = 0; i < 26; i++)
		arr[i] = 0;
	for (int i = 0; i < s.length(); i++) {
		arr[s.at(i) - 'a']++;
	}
	int cnt = 0;
	for (int i = 0; i < 26; i++) {
		if (arr[i] % 2 == 1)
			cnt++;
	}
	if (cnt % 2 == 0 && cnt != 0) printf("Second\n");
	else printf("First\n");
}