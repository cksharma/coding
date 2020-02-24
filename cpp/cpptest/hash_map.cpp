#include <bits/stdc++.h>
using namespace std;

struct Person {
    string name;
    int age;

    Person(const string& name, int age) {
        this->name = name;
        this->age = age;
    }

    bool operator<(const Person& p) const {
        if (this->name != p.name) return this->name < p.name;
        return this->age < p.age;
    }

    bool operator==(const Person& other) const {
        return name == other.name && age == other.age;
    }
};

struct PersonComparator {
    bool operator()(const Person& p1, const Person& p2) const {
        if (p1.name != p2.name) return p1.name < p2.name;
        return p1.age < p2.age;
    }
};

struct PersonHash {
    bool operator()(const Person& p) const {
        return hash<string>()(p.name) << 1 | hash<int>()(p.age) << 1;
    }
};

struct PersonEquality {
    bool operator()(const Person& p1, const Person& p2) const {
        return p1.age == p2.age && p1.name == p2.name;
    }
};

namespace std {
    template <>
    struct hash<Person> {
        size_t operator()(const Person& p) const {
            return hash<string>()(p.name) << 1 | hash<int>()(p.age);
        }
    };
}

ostream& operator<<(ostream& os, const Person& p) {
    os << "Name = " << p.name << ", age = " << p.age;
    return os;
}

int main()
{
    unordered_set<Person> p;
    p.insert(Person{"Chandra", 100});
    cout << p.size() << endl;
    cout << *p.begin() << endl;
}
