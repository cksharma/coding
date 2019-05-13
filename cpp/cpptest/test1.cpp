#include <bits/stdc++.h>
using namespace std;

struct Person {
    string name;
    int age;
};

bool operator<( const Person& lhs, const Person& rhs ) {
    if( lhs.name != rhs.name ) {
        cout << "Checking by name lhs=" << lhs.name << ", rhs=" << rhs.name << endl;
        return lhs.name < rhs.name;
    }
    cout << "Checking by age lhs=" << lhs.age << ", rhs=" << rhs.age << endl;
    return lhs.age < rhs.age;
}

ostream& operator<<(ostream& os, const Person& p) {
    os << p.name << ", " << p.age;
    return os;
}

template <typename Container>
void f_dbg( Container& c)
{
    ostringstream os;
    os << "[";
    for (auto it = c.begin(); it != c.end(); ++it) {
        os << (*it) << ", ";
    }
    os << "]";
    cout << os.str() << endl;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    set< Person > persons;
    persons.insert ( { "Chandra", 10  } );
    persons.insert ( { "Raja", 20  } );
    f_dbg(persons);

    set<string> st = {"adsasd", "asdasdasd", "fdgdfg", "Apple"};
    f_dbg(st);
}
