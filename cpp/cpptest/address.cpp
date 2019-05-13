#include <bits/stdc++.h>
using namespace std;
int main() {
	int i = 10;
	int& r = i;
	int* p = &i;
	
	cout << &r << "  " << p << endl;
	return 0;	
}