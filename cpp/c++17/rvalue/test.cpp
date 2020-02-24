#include <bits/stdc++.h>
using namespace std;

/*template <class T>
concept Integral = std::is_integral<T>::value;

template< typename T>
concept floating_number = is_floating_point_v<T>;*/

struct Person {
    int age;
    string name;
};

void solve(const Person&& a)
{
    cout << "Rvalue" << endl;
}

void solve(const Person& a)
{
    cout << "Lvalue" << endl;
}

void solve(int& a)
{
    cout << "int lvalue" << endl;
}

void solve(int&& a)
{
    cout << "int rvalue" << endl;
}

template <typename T>
void pass(T&& t)
{
    solve(forward<T>(t));
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    Person p{10, "chandrA"};
    pass(p);
    pass(Person{10, "chandra"});

    pass(10);
    int b = 100;pass(b);
}
