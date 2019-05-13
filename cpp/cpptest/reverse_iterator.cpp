#include <bits/stdc++.h>
using namespace std;

int main() {
	list<int> lst = {1, 2, 3, 4, 5, 6, 7, 8};
	cout << lst.size() << endl;
	const auto& it1 = lst.begin();
	const auto& it2 = (lst.rend() ).base();
	cout << "Address1=" << &it1 << ", Address2=" << &it2 << endl;
	cout << "Value1 =" << *it1 << endl;
	cout << "Value2 =" << *it2 << endl;
	
	lst.erase( next( lst.rbegin() ).base() );
	
	cout << lst.size() << endl;
}