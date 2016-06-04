#include <bits/stdc++.h>
using namespace std;

const int k = 5;

//iterators
void iteratorsArray(array<int, k> arr) {
	cout << "\n*******ITERATORS********\n";
	
	cout << "\nenhanced for loop" << endl;
	for (auto& item : arr) cout << item << " ";

	cout << "\n\nforward iterators" << endl;
	for (auto it = arr.begin(); it != arr.end(); it++) cout << *it << " ";

	cout <<"\n\nreverse iterators" << endl;
	for (auto it = arr.rbegin(); it != arr.rend(); it++) cout << *it << " ";

	cout << "\n\nconst forward iterators " << endl;
	for (auto it = arr.cbegin(); it != arr.cend(); it++)  cout << *it << " ";

	cout << "\n\nconst reverse iterators " << endl;
	for (auto it = arr.crbegin(); it != arr.crend(); it++) cout << *it << " ";

	cout << "\n\n*********** ITERATORS END ************\n";
}

void capacity(array<int, k> arr) {
	cout << "\n************* CAPACITY ************" << endl;
	cout << "size : " << arr.size() << endl;
	cout << "sizeof: " << sizeof(arr) << endl;
	cout << "isEmpty: " << arr.empty() << endl;
	array<int, 4> temp;
	cout << "Front :" << temp.front() << endl;
	cout << "\n************* CAPACITY END ************" << endl;
}

void access(array<int, k> arr) {
	cout <<"\n*************** ACCESS ****************** " << endl;
	
	cout <<"\nSquare bracket" << endl;
	for (int i = 0; i < k; i++) cout << arr[i] << " ";
	
	cout << "\n\nat" << endl;
	for (int i = 0; i < k; i++) cout << arr.at(i) << " ";

	cout <<"\n\nfront element :" << arr.front() << endl;
	//to change the element at front you can do something like arr.front() = 100;

	cout <<"\n\nback element :" << arr.back() << endl;
	//to change the element at back you ca do something like arr.back() = 100;
	
	cout << "\ndata from int arr\n";
	cout << arr.data() << endl;

	const char* str = "Test string";
	array<char, 12> dataArr;
	memcpy(dataArr.data(), str, 12);
	cout << "\ndata for char array\n" << dataArr.data() << endl;

	cout <<"\n*************** ACCESS END ****************** " << endl;
}

int main() {
	
	array<int, k> arr = {2, 16, 77, 34, 50};

	iteratorsArray(arr);

	capacity(arr);

	access(arr);
	
}