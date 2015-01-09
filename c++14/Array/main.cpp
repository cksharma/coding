#include <iostream>
#include <array>
using namespace std;
int main() {
	array<int, 4> myarray;

	//Pushing some stuffs in array
	myarray.fill(10);

	// Assigning some values to myarray;
	for (int i = 0; i < myarray.size(); i++) {
		myarray[i] = i + 2;
	}

	for (auto it = myarray.begin(); it < myarray.end(); it++) {
		cout << *it << endl;
	}

	for (auto rit = myarray.rbegin(); rit < myarray.rend(); rit++) {
		cout << *rit << endl;
	}

	//array::data
	cout << "=============================" << endl;
	array<char, 10> char_array;
	for (int i = 0; i < char_array.size(); i++) {
		char_array[i] = (char)('a' + i);
	}
	cout << char_array.data() << endl;

	system("pause");
}

