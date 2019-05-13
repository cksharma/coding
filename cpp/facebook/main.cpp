#include <bits/stdc++.h>
using namespace std;

struct Person {
    string name;
    int age;
    Person(const string& name, int age) : name(name), age(age) {}
    bool operator==(const Person& rhs) const {
        const Person& lhs = *this;
        return lhs.name == rhs.name and lhs.age == rhs.age;
    }
};

struct PersonHash {
    size_t operator()(const Person& p) const {
        return hash<int>()(p.age) + hash<string>()(p.name);
    }
};

struct PersonEquality {
    bool operator()(const Person& lhs, const Person& rhs) const {
        return lhs.name == rhs.name and lhs.age == rhs.age;
    }
};

namespace std {
    template<>
    struct hash<Person> {
        size_t operator()(const Person& p) const {
            return hash<int>()(p.age) + hash<string>()(p.name);
        }
    };
}

ostream& operator<<(ostream& os, const Person& p) {
    os << p.name << ", " << p.age;
    return os;
}

int main()
{
    Person p("Chandra", 10);
    unordered_set<Person> st; st.insert(p);
    cout << *st.begin() << endl;
}