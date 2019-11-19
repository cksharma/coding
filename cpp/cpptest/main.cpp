#include <bits/stdc++.h>
using namespace std;

struct Person {
	string name;
	int age;
	Person(const string& name_, int age_) : name(name_), age(age_) {}
};

using PersonPtr = shared_ptr<Person>;

PersonPtr getPersonInstance(int num) {
	if( num % 2 == 1) return nullptr;
	string name = "Chandra"; int age = 25;
	return PersonPtr( new Person(name, age) );
}

ostream& operator<<(ostream& os, const PersonPtr& ptr) {
	if( ptr == nullptr) os << ptr;
	else os << "[name=" << ptr->name << ",age=" << ptr->age << "]";
	return os;
}

void lower_upper_test() {
    set<int> st {1, 3, 5, 7, 9, 11, 13, 14, 15, 17};
    auto it1 = st.lower_bound(6); cout << "CKS1 " << *it1 << endl;
    auto it2 = st.upper_bound(14); cout << "CKS2 " << *it2 << endl;
    for (auto it = it1; it != it2; ++it) {
        cout << *it << ", ";
    }
    cout << endl;
}

int main()
{
	lower_upper_test();
	return 0;
}