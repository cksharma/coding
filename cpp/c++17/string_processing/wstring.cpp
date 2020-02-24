#include <bits/stdc++.h>
#define long long long
using namespace std;

int main()
{
    string str = "ラーメン";
    wstring wstr = L"ラーメン";
    cout << "Str =" << str << ", size " << str.size() << ", length " << str.length() << endl;
    wstring_view wstr_view = wstr;
    cout << "wstr size =" << wstr.size() << ", length " << wstr.length() << endl;

    string cks = "ABCDEFG";
    if (cks.find('R') == string::npos) cout << "NPOS : NOT FOUND" << endl;
    cout << "front char " << cks.front() <<", back char " << cks.back() << endl;
}
