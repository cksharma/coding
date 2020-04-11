#include <bits/stdc++.h>
#include <any>
using namespace std;

int main()
{
    any a = 1;
    try {
        cout << any_cast<int>(a) << endl;
       a = string("ChandrA");
       cout << any_cast<string>(a) << endl;
    } catch( runtime_error& ex) {
        cout << "Got an exxception " << ex.what() << endl;
    }
    return 0;
}
