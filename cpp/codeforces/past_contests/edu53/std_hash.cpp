#include <bits/stdc++.h>
using namespace std;

struct Person {
	int age;
	string name;
	
	bool operator==(const Person& rhs) const {
		return age == rhs.age and name == rhs.name;
	}
};

inline ostream& operator<<(ostream& os, const Person& p) {
	os << "Age: " << p.age << ", name: " << p.name;
	return os; 
}

namespace std {
	template<> struct hash<Person> {
		size_t operator()(const Person& p) const {
			return hash<int>()(p.age) + hash<string>()(p.name);
		}
	};
}

int main()
{
	Person p3 {30, "Chandra"};
	Person p1 {10, "Chandra"};
	Person p2 {20, "Chandra"};
	Person p4 {20, "Kamal"};
	unordered_set<Person> st {p1, p2};
	cout << st.size() << endl;
	
	auto PersonHash = [](const Person& p) {	return hash<int>()(p.age) + hash<string>()(p.name); };
	auto PersonEquals = [](const Person& lhs, const Person& rhs) { return lhs.age == rhs.age && lhs.name == rhs.name;};
	unordered_set<Person, decltype(PersonHash), decltype(PersonEquals)> SET(10, PersonHash, PersonEquals);
	SET.insert(p1); SET.insert(p2);
	cout << SET.size() << endl;
	
	auto PersonComparator = [](const Person& lhs, const Person& rhs) {
		if(lhs.age != rhs.age) return lhs.age < rhs.age;
		return lhs.name < rhs.name;
	};
	vector<Person> vec { p3, p1, p2, p4};
	sort( vec.begin(), vec.end(), PersonComparator);
	for(auto& item : vec) {
		cout << item << endl;
	}	
	return 0;
}