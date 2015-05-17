#include <iostream>
#include <cstdio>
#include <sstream>
using namespace std;

int nume = 103993;
const int deno = 33102;
const int total = (int)2000;
string str = "";

string toString(int n)
{
	stringstream ss;
	ss << n;
	string sf;
	ss >> sf;
	return sf;
}

void init() {
	for (int i = 0; i < total; i++) {
		int factor = nume / deno;
		int rem = nume - deno * factor;
		str += toString(factor);
		while(rem * 10 < deno) {
			rem *= 10;
			str += "0";
		}
		nume = rem * 10;
		if (i == 0) str = "3.";
	}
}

int main() {
	int K;
	int x;
	
	init();
	
	cin >> K;
	for (int i = 0; i < K; i++) {
		 cin >> x;
		 if (x == 0) {
			 printf("3\n");
		 } else {
			 cout << str.substr(0, x + 2) << endl;
		 }
	}	
}