#include <iostream>
#include <forward_list>
#include <vector>
using namespace std;

template<class CKS> CKS by_two(CKS& x) {
	for (auto& num : x) {
		num *= 3;
	}
	return x;
}

int main() {
	
	std::forward_list<int> first;                      // default: empty
	std::forward_list<int> second(3, 77);              // fill: 3 seventy-sevens
	std::forward_list<int> third(second.begin(), second.end()); // range initialization
	std::forward_list<int> fourth(third);            // copy constructor
	
	//the moment you move fourth, the data inside fourth moved to fifth.
	std::forward_list<int> fifth(std::move(fourth));  // move ctor. (fourth wasted)
	std::forward_list<int> sixth = { 3, 52, 25, 90 };    // initializer_list constructor

	std::cout << "first:"; for (int& x : first)  std::cout << " " << x; std::cout << '\n';
	std::cout << "second:"; for (int& x : second) std::cout << " " << x; std::cout << '\n';
	std::cout << "third:";  for (int& x : third)  std::cout << " " << x; std::cout << '\n';
	std::cout << "fourth:"; for (int& x : fourth) std::cout << " " << x; std::cout << '\n';
	std::cout << "fifth:";  for (int& x : fifth)  std::cout << " " << x; std::cout << '\n';
	std::cout << "sixth:";  for (int& x : sixth)  std::cout << " " << x; std::cout << '\n';
	//std::cout << "fourth:"; for (int& x : fourth) std::cout << " " << x; std::cout << '\n';
	
	
	forward_list<int> second_1(3, 5);
	second_1 = by_two(second_1);
	for (auto it = second_1.begin(); it != second_1.end(); it++) {
		cout << *it << endl;
	}

	cout << first.max_size() << endl;

	vector<int> v;
	for (int i = 0; i < 10; i++) {
		v.emplace_back(i);
	}
	v = by_two(v);
	cout << "==============================================" << endl;
	int *first = v.data();
	for (auto& x : v) {
		cout << x << endl;
	}
}