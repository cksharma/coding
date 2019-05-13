#include <bits/stdc++.h>
using namespace std;

struct Person {
    string name;
    int age;
    Person(string name_, int age_) : name(name_), age(age_) {}
    Person(const Person& p) = default;
    Person& operator=(const Person& p) = default;

    Person(Person&&p) = default;
    Person& operator=(Person&& p) = default;
};

ostream& operator<<(ostream& os, const Person& p) {
    os << "[name=" << p.name << ", age=" << p.age << "]";
    return os;
}

int main()
{
    Person p ("Chandra", 20);
    Person copy(p);
    Person assign = p;
    cout << copy << endl;
    cout << assign << endl;

    Person* p1 = new Person("Chandra", 25);
    shared_ptr<Person> pptr(p1);
    weak_ptr<Person> wp1(pptr);
    cout << "Name = " << pptr->name << ", age = " << pptr->age << endl;

    cout << "before " <<  wp1.expired() << endl;
    pptr = nullptr;
    cout << "after " << wp1.expired() << endl;
}