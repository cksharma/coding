#include <bits/stdc++.h>
using namespace std;

void print(deque<int> mydeque);

void init() {
	cout <<"-------member function------" << endl;
	//constructors in deque
	deque<int> first; //default constructor
	deque<int> second(4, 100); //of size 4 and each with 100 as value
	deque<int> third(second.begin(), second.end()); //new deque by iterating other deque
	deque<int> fourth(third); //copy constructor

	int myInts[] = {16, 2, 77, 29};
	deque<int> fifth(myInts, myInts + sizeof(myInts) / sizeof(int));

	//destructors in deque
	//calls allocator_traits::destroy

	//operator overloading for = (equal to sign)
	deque<int> d1 (3);    // deque with 3 zero-initialized ints
  	deque<int> d2 (5);   // deque with 5 zero-initialized ints

  	d2 = d1;
  	d1 = deque<int>();  //looks like new feature in C++11
  	
  	cout << "Size of first: " << int (d1.size()) << '\n';
  	cout << "Size of second: " << int (d2.size()) << '\n';
}

void iterators() {
	cout <<"------Iterators---------" << endl;
	deque<int> mydeque;
	for (int i = 1; i <= 5; i++) mydeque.push_back(i);
	for (deque<int>::iterator it = mydeque.begin(); it != mydeque.end(); it++) cout << *it << " ";
	cout << endl;
	for (deque<int>::reverse_iterator it = mydeque.rbegin(); it != mydeque.rend(); it++) cout << *it << " ";
	cout << endl;
	for (deque<int>::const_iterator it = mydeque.cbegin(); it != mydeque.cend(); it++) cout << *it << " ";
	cout << endl;
	for (deque<int>::const_reverse_iterator it = mydeque.crbegin(); it != mydeque.crend(); it++) cout << *it << " ";
	cout << endl;
}

void capacity() {
	cout << "\n----------Capacity---------" << endl;
	deque<int> myInts(5, 1);
	cout << "size:" << myInts.size() << endl;
	myInts.insert(myInts.begin(), 5, 100);
	cout << "size:" << myInts.size() << " Front element: " << myInts.front() << endl;
	cout << "max_size " << myInts.max_size() << endl;
	myInts.resize(5);
	cout << "size : " << myInts.size() << " Front element: " << myInts.front() << endl;
	size_t t = myInts.size();
	cout << "size_t: " << t << endl;

	deque<int> mydeque(100);
	mydeque.shrink_to_fit();
	cout << "size:" << mydeque.size() << " front :" << mydeque.front() << endl;
}

void element_access() {
	deque<int> mydeque(10);
	for (int i = 0; i < mydeque.size(); i++) mydeque[i] = i + 1;
	reverse(mydeque.begin(), mydeque.end());
	cout << "elements after reversing" << endl;
	for (int i = 0; i < mydeque.size(); i++) cout << mydeque[i] << " ";
	cout << "\n";
	cout << "Fifth element: " << mydeque[4] << endl;
	cout << "Front element: " << mydeque.front() << endl;
	cout << "Back element: " << mydeque.back() << endl;
}

void modifiers() {
	cout << "Assign in deque" << endl;
	deque<int> first;
	first.assign(7, 100);
	cout << "Size of first: " << first.size() << endl;

	deque<int> second;
	second.assign(first.begin() + 1, first.end() - 1);
	cout << "Size of second: " << second.size() << endl;


	deque<int> mydeque;
	for (int i = 0; i < 5; i++) mydeque.push_back(i + 1);
	mydeque.push_front(-1);
	print(mydeque);

	mydeque.pop_back();
	mydeque.pop_front();
	print(mydeque);


	mydeque.erase(mydeque.begin() + 2);
	mydeque.erase(mydeque.begin(), mydeque.end() - 1);
	print(mydeque);

	cout << "Swapping behavior" << endl;
	deque<int> foo (3,100);   // three ints with a value of 100
   	deque<int> bar (5,200);   // five ints with a value of 200
   	cout << "Before swapping Foo size: " << foo.size() << "  Bar size: " << bar.size() << endl;

  	foo.swap(bar);
  	cout << "After swapping Foo size: " << foo.size() << "  Bar size: " << bar.size() << endl;

  	cout << "emplace in deque" << endl;
  	mydeque = deque<int>();
  	mydeque = {10,20,30};
  	print(mydeque);
  	mydeque.emplace(mydeque.begin() + 2, 100);
  	print(mydeque);

  	mydeque.emplace_back(200);
  	mydeque.emplace_front(300);
  	print(mydeque);
}

void operators() {
	deque<int> foo(3, 100);
	deque<int> bar(2, 200);
	cout << "Is equal ? " << (foo == bar) << endl;
	cout << "Is foo less than bar " << (foo < bar) << endl;
	cout << "Is foo greater than bar " << (foo > bar) << endl;
}

void print(deque<int> mydeque) {
	for (const auto& item : mydeque) {
		cout << item << " ";
	}
	cout << endl;
}

int main() {

	init();
	iterators();
	capacity();
	element_access();
	modifiers();
	operators();
}