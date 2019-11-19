#include <bits/stdc++.h>
using namespace std;


struct Person {
    string name;
    int age;
    Person(const string& name, int age) : name(name), age(age) {}
};

ostream& operator<<(ostream& os, const Person& t) {
    os << t.name << ", " << t.age;
    return os;
}

void pr(const Person&& p)
{
    cout << "As RVALUE" << endl;
}

void pr(const Person& p)
{
    cout << "AS LVALUE" << endl;
}

template <typename T>
void rValueTest(T&& t)
{
    cout << t << endl;
    pr(forward<T>(t));
}

bool compPerson(const Person& lhs, const Person& rhs)
{
    int cmp = lhs.name.compare(rhs.name);
    if (cmp != 0) return cmp < 0;
    return lhs.age < rhs.age;
}

bool operator==(const Person& lhs, const Person& rhs)
{
    return lhs.age == rhs.age and lhs.name == rhs.name;
}

namespace std
{
    template <>
    struct hash<Person>
    {
        size_t operator()(const Person& p) const
        {
            //return p.name.length() + p.age;
            return hash<string>()(p.name) + hash<int>()(p.age);
        }
    };
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    Person p("Chandra", 10);
    rValueTest(p);

    rValueTest(Person("ChandraRValue", 15));

    auto PersonHash = [](const Person& p) {
        return hash<string>()(p.name) + hash<int>()(p.age);
    };
    auto PersonEquals = [](const Person& lhs, const Person& rhs){
        return lhs.age == rhs.age && lhs.name == rhs.name;
    };

    //unordered_set<Person, decltype(PersonHash), decltype(PersonEquals) > uSet(10, PersonHash, PersonEquals);
    unordered_set<Person> uSet;
    uSet.insert(Person("asdad", 10));
    uSet.insert(Person("asdad", 10));
    uSet.insert(Person("CKSS", 10));
    cout << uSet.size() << endl;

    cout << "HASHING FUNCTION " << endl;
    auto hf = uSet.hash_function();
    for (const auto& item : uSet) {
        cout << hf(item) << endl;
    }
}
