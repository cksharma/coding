#include <iostream>
#include <stdexcept>
#include <bits/stdc++.h>
using namespace std;

// C++11 constexpr functions use recursion rather than iteration
// (C++14 constexpr functions may use local variables and loops)
constexpr int factorial(int n)
{
    return n <= 1 ? 1 : (n * factorial(n - 1));
}

constexpr int fibonacci(int n)
{
    return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
}


// literal class
class conststr {
    const char* p;
    std::size_t sz;
public:
    template<std::size_t N>
    constexpr conststr(const char(&a)[N]): p(a), sz(N - 1) {}

    // constexpr functions signal errors by throwing exceptions
    // in C++11, they must do so from the conditional operator ?:
    constexpr char operator[](std::size_t n) const
    {
        return n < sz ? p[n] : throw std::out_of_range("");
    }
    constexpr std::size_t size() const { return sz; }
};

// C++11 constexpr functions had to put everything in a single return statement
// (C++14 doesn't have that requirement)
constexpr std::size_t countlower(conststr s, std::size_t n = 0,
                                             std::size_t c = 0)
{
    return n == s.size() ? c :
           'a' <= s[n] && s[n] <= 'z' ? countlower(s, n + 1, c + 1) :
                                       countlower(s, n + 1, c);
}

// output function that requires a compile-time constant, for testing
template<int n>
struct constN
{
    constN() { std::cout << n << '\n'; }
};

constexpr bool isPrime(long long n) {
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (long long i = 3; i * i <= n; i += 2) {
        if (n % i == 0) return false;
    }
    return n > 1LL;
}

constexpr int initPrimes(int a) {
    int cnt = 0;
    for (int i = 2; i <= a; ++i) {
        if (isPrime(i)) {
            //v.push_back(i);
            cnt++;
        }
    }
    return cnt;
}

int main()
{
    std::cout << "4! = " ;
    constN<factorial(4)> out1; // computed at compile time

    volatile int k = 8; // disallow optimization using volatile
    std::cout << k << "! = " << factorial(k) << '\n'; // computed at run time

    std::cout << "the number of lowercase letters in \"Hello, world!\" is ";
    constN<countlower("Hello, world!")> out2; // implicitly converted to conststr

    std::cout << "CKS fibonacci" << fibonacci(10) << endl;

    constN<initPrimes(100)> cn;
}
