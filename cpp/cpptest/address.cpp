#include <bits/stdc++.h>
using namespace std;

// With C++17, it is recommended to write <int[]> if
// shared_ptr holds the reference to an array.
// That way we can easily know if the sp is for single
// int or array. Pretty cool.

void shared_ptr_test() {
    cout << "SharedPtr begin" << endl;

    int* arr = new int[100]; iota(arr, arr + 100, 0);
    shared_ptr<int[]> sp(arr);
    for (int i = 0; i < 100; ++i) {
        cout << sp.get()[i] << ", ";
    }

    cout << endl;
    int* k = new int(999);
    shared_ptr<int> sp1(k);
    cout << *sp1.get() << endl;

    cout << "SharedPtr end" << endl;
}

int main() {
	int i = 10;
	int& r = i;
	int* p = &i;
	cout << &r << "  " << p << endl;

	shared_ptr_test();

	return 0;
}