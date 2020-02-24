#include <bits/stdc++.h>
using namespace std;

int main()
{
    std::string str = "helloworld";
    std::intmax_t val = std::strtoimax(str.c_str(), nullptr, 36);
    std::cout << str << " in base 36 is " << val << " in base 10\n";

    string ss = to_string(val);
    cout << "CKS is here " << ss << endl;

    char* nptr;
    val = std::strtoimax(str.c_str(), &nptr, 30);
    if(nptr != &str[0] + str.size())
        std::cout << str << " in base 30 is invalid."
                  << " The first invalid digit is " << *nptr << '\n';

    cout << stoi("12345678", nullptr, 10) << endl;
    cout << stoi("12345678", nullptr, 2) << endl;
}