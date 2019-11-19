#include <bits/stdc++.h>
using namespace std;

struct Person {
    string name;
    int age;
    string company;

    Person(const string& n, int a, const string& c) :
    name(n), age(a), company(c) {}
};

struct ObjectComparator {
    bool operator()(const Person& lhs, const Person& rhs) const {
        if (lhs.name != rhs.name) return lhs.name < rhs.name;
        if (lhs.age != rhs.age) return lhs.age < rhs.age;
        if (lhs.company != rhs.company) return lhs.company < rhs.company;
        return false;
    }
};

struct ObjectHash {
    bool operator()(const Person& p) const {
        return hash<string>()(p.name) + hash<int>()(p.age) + hash<string>()(p.company);
    }
};

struct ObjectEquals {
    bool operator()(const Person& lhs, const Person& rhs) const {
        return lhs.name == rhs.name && lhs.age == rhs.age &&  lhs.company == rhs.company;
    }
};

namespace std {
    template <>
    struct hash<Person>
    {
        size_t operator()(const Person& p) const {
            return hash<string>()(p.name) + hash<int>()(p.age) + hash<string>()(p.company);
        }
    };
}

bool operator==(const Person& lhs, const Person& rhs) {
    return lhs.name == rhs.name && lhs.age == rhs.age && lhs.company == rhs.company;
}

bool next_permutation(vector<int>& v) {
    for (int i = v.size() - 2; i >= 0; --i) {
        if (v[i + 1] > v[i]) {
            for (int j = v.size() - 1; j > i; --j) {
                if (v[j] > v[i]) {
                    swap(v[j], v[i]);
                    reverse(v.begin() + i + 1, v.end());
                    return true;
                }
            }
        }
    }
    return false;
}

ostream& operator<<(ostream& os, const vector<int>& v) {
    os << "[";
    for (int item : v) os << item << ", ";
    os << "]";
    return os;
}

void permuation(){
    int cnt = 0;
    vector<int> v = {1, 2, 3, 4, 5, 6};
    do {
        cout << v << endl;
        ++cnt;
    } while (next_permutation(v));
    cout << "CKS total" << cnt << endl;
}

void int_to_roman()
{
    int num = 12;
    //cout << "Enter the number" << endl;
    map<char, int> mp = { { 'I' , 1}, {'V' , 5}, {'X' , 10}, {'L' , 50}, {'C' , 100},
                          {'D' , 500}, {'M' , 1000 } };
    vector<int> parts;
    while (num > 10) {
        int d = (int)log10(num) + 1;
        int fact = pow(10, d);
        int q = num / fact;
        parts.push_back( q * fact );
        num = num - q * fact;
        cout << "=>" << num << ",";
    }
    cout << parts << endl;
    return;
}

struct Test {
    int num;
    string name;

    string getName() & {
        cout << "Only lvalue  call" << endl;
        return name;
    }

    string getName() && {
        cout << "Only rvalue call" << endl;
        return name;
    }

    Test() {
        num = 100; name = "Chandra ";
    }
};

void lvalue_rvalue()
{
    Test t;
    cout << Test().getName() << endl;
    cout << endl << endl;
    cout << t.getName() << endl;
}

struct Graph {
    string source;
    set<string> destinations;
};

void graph() {

}


void lambda() {
    auto cmp = [](const Person& lhs, const Person& rhs) { return lhs.name < rhs.name; };
    set<Person, decltype(cmp) > my_set(cmp);
    cout << my_set.size() << endl;
}


constexpr int constexpr_test(const int i)
{
    const double sqrt_5 = sqrt(5);
    return static_cast<int> ( (pow( 1 + sqrt_5, i) - pow(1 - sqrt_5, i)) / ( pow(2, i) * sqrt_5) );
}

template<int I>
struct Fib {
    static const int i = Fib<I - 1>::i + Fib<I - 2>::i;
};

template <>
struct Fib<0> {
    static const int i = 0;
};

template <>
struct Fib<1> {
    static const int i = 1;
};


int main()
{
    //permuation();
    int_to_roman();
    //lvalue_rvalue();
    //graph();
    lambda();
    cout << constexpr_test(10) << endl;
}


