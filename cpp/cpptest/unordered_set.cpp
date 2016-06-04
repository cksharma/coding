#include <bits/stdc++.h>
using namespace std;

class Customer {

public:
	string name;
	int age;

	Customer(string _name, int _age) :  name(_name), age(_age) {
		cout << "constructor called " << name << " " << age << endl;
	}	
};

struct Hash {
	int operator() (const Customer& cust) const {
		return hash<string>()(cust.name) + cust.age;
	}
};

bool operator==(const Customer& cust1, const Customer& cust2) {
	return cust1.name == cust2.name && cust1.age == cust2.age;
}

int main() {
	unordered_set<Customer, Hash> mySet;
	mySet.insert(Customer("chandra", 10));
	mySet.insert(Customer("chandra", 12));
	mySet.insert(Customer("Ram", 10));
	mySet.insert(Customer("Ram", 10));
	cout << "Size of custom class: " << mySet.size() << endl;
}