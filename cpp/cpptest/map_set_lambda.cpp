#include <bits/stdc++.h>
using namespace std;

void testOrderedSetUnorderedSet();

struct Person {
    string name;
    int age;
    Person(string name_, int age_) : name(name_), age(age_) {}

    bool operator<(const Person& p) const {
        if(name != p.name) return name < p.name;
        return age < p.age;
    }

    bool operator==(const Person& p) const {
        return name == p.name && age == p.age;
    }
};

ostream& operator<<(ostream& os, const Person& p) {
    os << "[name=" << p.name << ", age=" << p.age << "]";
    return os;
}

namespace std {
    template <>
    struct hash<Person> {
        size_t operator()(const Person& p) const {
            return hash<string>()(p.name ) + hash<int>()(p.age);
        }
    };
}

struct PersonComparator {
    bool operator()(const Person& lhs, const Person& rhs) const {
        if(lhs.name != rhs.name) return lhs.name < rhs.name;
        return lhs.age < rhs.age;
    }
};

struct PersonHash {
    size_t operator()(const Person& p) const {
        return hash<string>()(p.name ) + hash<int>()(p.age);
    }
};

struct PersonEquality {
    bool operator()(const Person& lhs, const Person& rhs) const {
        return lhs.name == rhs.name && lhs.age == rhs.age;
    }
};

vector<Person> getPersons(int n) {
    vector<Person> result;
    for(int i = 1; i <= n; i++) {
        int randVal = rand() % n;
        result.emplace_back( "Chandra" + to_string(randVal), randVal );
    }
    return result;
}

int main()
{
    testOrderedSetUnorderedSet();
}

template<typename Set, typename Vector, typename Message>
void evaluate(Set& t, Vector& v, Message msg) {
    cout << "Start:" << msg << endl;
    for(auto& item : v) t.insert( item );
    for(const auto& item : t) {
        cout << item << endl;
    }
    cout << "Vector size=" << v.size()
         << ",  Set size=" << t.size() << endl;
    cout << "End:" << msg << endl << endl;
}

void testOrderedSetUnorderedSet() {
    vector<Person> persons = getPersons(5);

    string msg1 = "TreeSet with overloaded operator<";
    set<Person> treeSet1;
    evaluate(treeSet1, persons, msg1);

    string msg2 = "TreeSet with custom Comparator(Functor)";
    set<Person, PersonComparator> treeSet2;
    evaluate(treeSet2, persons, msg2);

    string msg3 = "TreeSet with Lambda Comparator";
    auto LambdaPersonComparator = [](const Person& lhs, const Person& rhs) {
        if( lhs.name != rhs.name ) return lhs.name < rhs.name;
        return lhs.age < rhs.age;
    };
    set<Person, decltype(LambdaPersonComparator)> treeSet3(LambdaPersonComparator);
    evaluate(treeSet3, persons, msg3);

    string msg4 = "HashSet with overloaded== and namespace std hash";
    unordered_set<Person> hashSet1;
    evaluate( hashSet1, persons, msg4);

    string msg5 = "HashSet with overloaded== and Hash Functor";
    unordered_set<Person, PersonHash> hashSet2;
    evaluate(hashSet2, persons, msg5);

    string msg6 = "HashSet with Hash Functor and Equals Functor";
    unordered_set<Person, PersonHash, PersonEquality> hashSet3;
    evaluate(hashSet3, persons, msg6);

    string msg7 = "HashSet with lambda as HashFunction and Lambda as Equals function";
    auto LambdaPersonHash = [](const Person& p) {
        return hash<Person>()(p);
    };
    auto LambdaPersonEquality = [](const Person& lhs, const Person& rhs) {
        return lhs == rhs;
    };

    unordered_set<Person, decltype(LambdaPersonHash), decltype(LambdaPersonEquality)> hashSet4 (7,
            LambdaPersonHash, LambdaPersonEquality);
    evaluate(hashSet4, persons, msg7);
}


