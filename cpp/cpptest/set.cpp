#include <bits/stdc++.h>
using namespace std;

class Customer {

public:
	string name;
	int age;

	Customer(string _name, int _age) :  name(_name), age(_age) {
		cout << "constructor called " << name << " " << age << endl;
	}
	bool operator< (const Customer& cust) const {
		if (name != cust.name) return name < cust.name;
		return age < cust.age;
	}
};

int main() {
	set<Customer> st;
	st.insert(Customer("Raja", 10));
	st.insert(Customer("Shyam", 10));
	st.insert(Customer("Raja", 10));
	cout << "Size of set: " << st.size() << endl;
}