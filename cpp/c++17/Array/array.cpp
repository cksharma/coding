#include <bits/stdc++.h>
using namespace std;

template< typename T, size_t N> 
constexpr int sizeofArray( T (&)[N]) {
    return N;
}

template <typename T>
constexpr void preprocess(T& myself)
{
    const int k = 100;
    bool isPrime[k + 1];
    fill( isPrime, isPrime + k + 1, true );
    isPrime[0] = isPrime[1] = false;
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

int main() {
    int myArr[] = {1, 2, 3, 4, 5, 6, 7};
    array<int, sizeofArray( myArr ) > arr;
    
    cout << arr.size() << endl;
    
    vector<int> v;
    preprocess(v);
    cout << v.size() << endl;
    
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
        
    return 0;
}