#include <bits/stdc++.h>
using namespace std;

template <typename T>
class MyClass
{
  public:
    T name;
    MyClass(T name) {
        this->name = name;
    }

    void print() {
        std::cout << "name=" << name << std::endl;
    }
};

template <auto ... seq>
class my_integer_sequence {
  public:
    my_integer_sequence(auto ... args ) {
        for(auto item : {args...} ) {
            std::cout << item << ", ";
        }
        std::cout << "\n";
    }
};

void constExprLambdas()
{
    auto identity = [](int n) constexpr { return n; };
    std::cout << "Value " << identity(100) << std::endl;
}

int main()
{
    MyClass ck("Chandra");
    ck.print();
    priority_queue<int> q;
    my_integer_sequence seq(1, 2, 3, 4, 5);

    constExprLambdas();

}