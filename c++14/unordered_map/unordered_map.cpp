#include <iostream>
#include <functional>
#include <unordered_map>
#include <bits/stdc++.h>
#include <string>
using namespace std;

size_t operator()(const pair<string, string>& x) {
	hash <string> hash_func;
	return hash_func(x.first) + hash_func(x.second);
}

int main() {
	unordered_map <string, string> mp;
	unordered_map <string, string> :: iterator it;
	mp.insert(make_pair("chandra", "USA"));
	mp["CKS"] = "Hello World";
	for (it = mp.begin(); it != mp.end(); it++) {
		cout << (*it).first << " " << (*it).second << endl;
	}
	//unordered_map <pair <string, string>, int> cks;
	//cks[make_pair("maka", "chut")] = 2;
	return 0;	
}
