#include <bits/stdc++.h>
using namespace std;

void splitspace(string s) {
	stringstream ss(s);
	string token;
	while (ss >> token) {
		cout << token << endl;
	}
}

void splitc(string s) {
	char str[s.length() + 1];
	strcpy(str, s.c_str());
	char *p = strtok(str, " ,");
	while (p != NULL) {
		cout << string(p) << endl;
		p = strtok(NULL, " ,");
	}
}

int main() {
	string s = "Hello World, is the best things,there is it?";
	//splitspace(s);
	splitc(s);
}