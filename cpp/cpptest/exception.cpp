#include <bits/stdc++.h>
using namespace std;

struct MyException : public runtime_error
{
    MyException(const string& arg) : runtime_error( arg ) {}
};

void callHim()
{
    throw MyException("Not good");
}

int main()
{
    try {
        callHim();
    } /*catch (const MyException& ex) {
        cout << "Achha lekin" << ex.what() << endl;
    } */catch( const runtime_error& rt) {
        cout << "Default " << rt.what() << endl;
    }
}
