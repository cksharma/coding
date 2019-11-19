#include <bits/stdc++.h>
using namespace std;

template< typename T, size_t N>
constexpr int sizeofArray( T (&)[N]) {
    return N;
}

template <typename T, size_t k>
constexpr T preprocess()
{
    T myself;
    cout << "K is" << k << endl;
    //array<bool, k> isPrime{true};
    //fill(isPrime.begin(), isPrime.end(), true);
    bool isPrime[k];
    fill(isPrime, isPrime + k, true);
    //for (int i = 0; i < k; ++i) isPrime[i] = true;
    isPrime[0] = false;
    isPrime[1] = false;
    for(int i = 2; i * i <= k; i++) {
        if( isPrime[i]) {
            for(int j = i * i; j <= k; j += i) {
                isPrime[j] = false;
            }
        }
    }
    for(int i = 0; i < k; ++i) {
        if( isPrime[i] ) myself.push_back( i );
    }
    return myself;
}


template <typename T>
void print( T& myself) {
    for(auto item : myself) cout << item << " ";
    cout << "\n";
}


int sum(int a, int b ){
    return a + b;
}

struct A {
    int a = INT_MIN, b = INT_MIN;

    A(int a1) : a(a1) { cout << "one arg constr" << endl;}
    A(int a1, int b1) : a(a1), b(b1) { cout << "two arg constr" << endl; }

    // Constructor
    operator bool() const { return true; }
};

ostream& operator<<(ostream& os, const A& lhs) {
    cout << " A = " << lhs.a << endl;
}

struct B {
    int a = INT_MIN, b = INT_MIN;

    explicit B(int a1) : a(a1) { cout << "B (int)" << endl;}
    explicit B(int a1, int b1) : a(a1), b(b1) { cout << "B (int, int)" << endl; }
    explicit operator bool() const { return true; }
};

void doNothing() {
    cout << "I am doing nothing" << endl;
}


void implicit_explicit_test() {
    cout << "implicit explicit start" << endl;
    struct CK1 {
        operator int() { return 200;}
    };
    struct CK2 {
        int operator()() {
            return 100;
        }
    };

    CK1 ck1;
    cout << "cks1 <" << ck1 << ">" << endl;

    CK2 ck2;
    cout << "cks2 <" << ck2() << ">" << endl;
    cout << "implicit explicit end" << endl;
}

// use defined type for the struct can be defined as
// operator int() { return 100; } ==> If this operator is overloaded inside the class, the class assignment
// compatible with the int.  If the class instance is cls, you can get the value from class type by cls
// int operator()() { return 100; } => now this is functor and functor is the function represenation or
// function pointer to the class.. Now if you have class instance.. you can get the behavior of this class
// using cls(), call.

void functor_test() {
    struct Addition {
        int num;
        int operator()(int add) {
            return num + add;
        }
        Addition(int n) : num(n) {}
        Addition() {}
    };

    cout << "\nFunctor test start" << endl;
    vector<int> v {1, 2, 3, 4, 5, 6, 7, 8};
    Addition add(0);
    transform(v.begin(), v.end(), v.begin(), [](int item) {
        return item + 5;
    });
    for (int item : v) cout << item << ", ";
    cout << endl;
    cout << "\nFunctor test end" << endl;
}

int main() {
    int myArr[] = {1, 2, 3, 4, 5, 6, 7};
    array<int, sizeofArray( myArr ) > arr;

    cout << arr.size() << endl;

    vector<int> v = preprocess<vector<int>, 100>();
    cout << "no of Primes intil 100 <" << v.size() << ">" << endl;

    print( v );

    //function<int (int, int> func = int (*)(int a, int b) { return a + b; };
    auto& func = sum;
    const function<int(int, int)>& cks = sum;

    cout << "AUTO = " << func(10, 10) << endl;

    cout << "CKS = " << cks(10, 10) << endl;

    // Explict keyword in C++
    A a = 10; cout << a << endl;
    A a1(10); cout << a1 << endl;
    A a2(10, 20); cout << a2 << endl;

    const function<void()>& nothing = doNothing;
    cout << "Calling doNothing" << endl;
    nothing();

    implicit_explicit_test();
    functor_test();

    return 0;
}