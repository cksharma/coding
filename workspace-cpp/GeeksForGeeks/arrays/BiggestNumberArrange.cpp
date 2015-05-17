#include <vector>
#include <map>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <string.h>
#include <set>
#include <climits>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;

string toString(int n) {
	stringstream ss;
	ss << n;
	string sf;
	ss >> sf;
	return sf;
}

typedef struct MyStruct {
	int number;
	string str;
} MyStruct;


bool operator<(const MyStruct &f, const MyStruct &s) {
	return f.number < s.number;
}


int strCompare(const MyStruct &f, const MyStruct &s) {
	int a = f.number;
	int b = s.number;
	if (a <= b) return 1;
	return 0;
}

int stringCompare(const string& _f, const string& _s) {
	string f = _f;
	string s = _s;
	char cf = f.at(f.length() - 1);
	char sf = s.at(s.length() - 1);
	while (f.length() < s.length()) {
		f += cf + "";
	}
	while (s.length() < f.length()) {
		s += sf + "";
	}
	cout << "came here";
	if (f < s)
		return 1;
	if (f > s)
		return -1;
	return 0;
}

int compare(const int &a, const int &b) {
	string f = toString(a);
	string s = toString(b);
	char cf = f.at(f.length() - 1);
	char sf = s.at(s.length() - 1);
	while (f.length() < s.length()) {
		f += cf;
	}
	while (s.length() < f.length()) {
		s += sf;
	}
	return f >= s;
}

void arrayTest() {
	int arr[] = { 9, 98, 999, 89};
	vector<int> v;
	int n = sizeof(arr) / sizeof(arr[0]);
	for (int i = 0; i < n; i++)
		v.push_back(arr[i]);
	cout << "SIZE OF ARRAY : " << n << endl;
	//sort(arr, arr + n, compare);
	sort(v.begin(), v.end(), compare);

	string ans = "";
	for (int i = 0; i < n; i++) {
		ans += toString(v[i]);
	}
	cout << ans << endl;
}

void sortStruct() {
	vector <MyStruct> v;
	for (int i = 0; i < 5; i++) {
		MyStruct st;
		st.number = rand();
		st.str = "Adobe";
		v.push_back(st);
	}
	sort(v.begin(), v.end(), strCompare);
	for (int i = 0; i < v.size(); i++) cout << v[i].number << " ";
}

int main() {
	//sortStruct();
	arrayTest();
}