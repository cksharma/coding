#include <bits/stdc++.h>
using namespace std;
 
struct Empty {};
struct Base { int a; };
struct Derived : Base { int b; };
struct Bit { unsigned bit: 1; };

struct Person { int age; string name; Person(int a, string n) : age(a), name(n) {} };

int main()
{
    Empty e;
    Derived d;
    Base& b = d;
    [[maybe_unused]] Bit bit;
    int a[10];
    Person p(1000, "Chandra Kant Sharma" );
    string ss; // uninitialized string
    string str = "HelloWorldIstheBest";
    int k; // uninitialized int
    std::cout << "size of empty class: "              << sizeof e          << '\n'
              << "size of pointer: "                  << sizeof &e         << '\n'
//            << "size of function: "                 << sizeof(void())    << '\n'  // error
//            << "size of incomplete type: "          << sizeof(int[])     << '\n'  // error
//            << "size of bit field: "                << sizeof bit.bit    << '\n'  // error
              << "size of array of 10 int: "          << sizeof(int[10])   << '\n'
              << "size of array of 10 int (2): "      << sizeof a          << '\n'
              << "length of array of 10 int: "        << ((sizeof a) / (sizeof *a)) << '\n'
              << "length of array of 10 int (2): "    << ((sizeof a) / (sizeof a[0])) << '\n'
              << "size of the Derived: "              << sizeof d          << '\n'
              << "size of the Derived through Base: " << sizeof b          << '\n'
              << "size of the Person class: "         << sizeof p          << '\n'
              << "size of the empty string: "         << sizeof ss         << '\n'
              << "size of the non-empty string: "     << sizeof str        << '\n'              
              << "size of the uninit int: "           << sizeof k          << '\n';
 
}