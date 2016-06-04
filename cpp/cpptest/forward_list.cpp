#include <bits/stdc++.h>
using namespace std;

void print(forward_list<int> list);

void init() {
	forward_list<int> first(4);
	for (auto it = first.begin(); it != first.end(); it++) cout << *it << " ";
	cout << endl;

	forward_list<int> second(3, 77);
	forward_list<int> third(second.begin(), second.end());
	print(third);

	forward_list<int> fourth(third);
	for (int i = 10; i < 30; i+= 10) fourth.push_front(i);
	print(fourth);
	
	fourth.reverse();
	print(fourth);
}
void iterators() {
	//begin and end
	forward_list<int> list = {20, 30, 40, 50};
	for (forward_list<int>::iterator it = list.begin(); it != list.end(); it++) cout << *it << " ";
	cout << endl;

	for (forward_list<int>::const_iterator it = list.begin(); it != list.end(); it++) cout << *it << " ";
	cout << endl;
	
	list.insert_after(list.before_begin(), 10);
	print(list);

	cout << "Front element: " << list.front() << endl;
}

void capacity() {
	forward_list<int> list = {20, 30, 40, 50};
	cout << "Is Empty : " << list.empty() << endl;
	cout << "Max size : " << list.max_size() << endl;
}

void print(forward_list<int> list) {
	for (auto& item : list) cout << item << " ";
	cout << endl;
}

void modifiers() {
	forward_list<int> first;
	forward_list<int> second;
	first.assign(4, 15);

	second.assign(first.begin(), first.end());
	first.assign({20, 25, 30});

	print(first);
	print(second);

	forward_list<pair<int, char>> list;
	list.emplace_front(10, 'a');
	list.emplace_front(20, 'b');
	list.emplace_front(30, 'c');
	for (auto& item : list) {
		cout << item.first << " " << item.second << endl;
	}
}

bool single_digit(int& value) {
	return value < 10;
}

bool unique_integral(double item1, double item2) {
	return (int)item1 == (int)item2;
}

void operations() {
	forward_list<int> list = {7, 8, 9, 10, 11, 12, 13, 14};
	list.remove_if(single_digit);
	print(list);

	forward_list<int> first = {1, 2, 3};
	forward_list<int> second = {10, 20, 30};
	first.splice_after(first.before_begin(), second);
	cout << "Print first list:\n "; print(first);
	cout << "Print secon list:\n";  print(second);

	forward_list<double> dlist = {1.1, 1.4, 2.5, 2.1,  3.4, 3.7, 5.6, 5.8, 7.9, 7.99};
	dlist.unique(unique_integral);
	for (auto& item : dlist) cout << item << " ";
	cout << endl;


	first = {3, 1, 7, 5};
	second = {4, 2, 6, 8};
	first.sort();
	second.sort();
	first.merge(second);
	cout << "Merge sort of the list:" << endl;
	print(first);

	first = {3, 1, 7, 5};
	second = {4, 2, 6, 8};
	first.sort(greater<int>());
	second.sort(greater<int>());
	second.merge(first, greater<int>());
	cout << "Reverse sorting merge : " << endl;
	print(second);

}

int main() {
	init();
	iterators();
	capacity();
	modifiers();
	operations();
}