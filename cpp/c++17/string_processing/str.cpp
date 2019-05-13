#include <bits/stdc++.h>
using namespace std;

struct Person {
    string name;
    int age;
    bool operator<(const Person& rhs) const {
        if (name != rhs.name) return name < rhs.name;
        return age < rhs.age;
    }
};

int main()
{
    string str = "{\"defaultVal\":\"0\",\"supportedVals\":[\"0\"]}";
    cout << str << endl;

    string str1  = "{\"defaultVal\":\"0\",\"supportedVals\":[\"0\"]}";
    cout << str1 << endl;
}