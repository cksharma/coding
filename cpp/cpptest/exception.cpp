#include <bits/stdc++.h>
using namespace std;

struct MyException : public runtime_error
{
    MyException(const string& arg) : runtime_error( arg ) {}
};

void callHim()
{
    throw MyException("Not good");
}

class Person {
    string name;
    int age;

    friend ostream& operator<<(ostream& os, const Person& p);
public:
    Person(const string& n, int a) : name(n), age(a) {}
};

ostream& operator<<(ostream& os, const Person& p) {
    os << "[" << p.name << ", " << p.age << "]" << endl;
}

int main()
{
    try {
        callHim();
    } catch (const MyException& ex) {
        cout << "Achha lekin <" << ex.what() << ">" << endl;
    } catch( const runtime_error& rt) {
        cout << "Default " << rt.what() << endl;
    }

    Person p("Chandra", 12);
    cout << p << endl;
}
